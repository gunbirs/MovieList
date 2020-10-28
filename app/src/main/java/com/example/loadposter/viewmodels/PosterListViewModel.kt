package com.example.loadposter.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loadposter.models.Category
import com.example.loadposter.models.CategoryDetails
import com.example.loadposter.models.PosterData
import com.example.loadposter.network.PostersApi
import com.example.loadposter.network.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Response

class PosterListViewModel : ViewModel() {

    val isLoading: MutableLiveData<Int> = MutableLiveData(0)
    val posterDataLiveData: MutableLiveData<ArrayList<PosterData>> = MutableLiveData()
    var currentPosterSummary: String? = null

    private val networkApi = RetrofitInstance.createNetworkRequest(PostersApi::class.java)

    /**
     * Function to fire 3 sequential network calls to get list of kids posters.
     */
    fun loadPosters() {
        viewModelScope.launch {
            val firstNetworkCallResult = firstNetworkCall()
            val secondNetworkCallResult = firstNetworkCallResult?.let { secondNetworkCall(it) }
            posterDataLiveData.value = secondNetworkCallResult?.let { thirdNetworkCall(it) }
        }
    }

    private suspend fun firstNetworkCall(): Category? {
        return execute { networkApi?.getCategories() }
    }

    private suspend fun secondNetworkCall(firstCallResult: Category): CategoryDetails? {
        val screenKids = firstCallResult.screens.find { it.title == QUERY_TITLE && it.screenType == QUERY_SCREEN_TYPE }

        val namespaceCategory = screenKids?.alias?.namespace
        val aliasCategory = screenKids?.alias?.alias

        if (!namespaceCategory.isNullOrEmpty() && !aliasCategory.isNullOrEmpty()) {
            return execute { networkApi?.getCategoryDetails(namespaceCategory, aliasCategory) }
        }

        return null
    }

    private suspend fun thirdNetworkCall(secondCallResult: CategoryDetails): ArrayList<PosterData> {
        val posterDataList = ArrayList<PosterData>()

        val collectionPoster = secondCallResult.collections.find { it.style == QUERY_STYLE }

        val namespaceCategoryDetails = collectionPoster?.alias?.namespace
        val aliasCategoryDetails = collectionPoster?.alias?.alias

        if (!namespaceCategoryDetails.isNullOrEmpty() && !aliasCategoryDetails.isNullOrEmpty()) {
            val posterResponse = execute { networkApi?.getPoster(namespaceCategoryDetails, aliasCategoryDetails) }
            posterResponse?.let {
                posterResponse.content.forEach { posterDataList.add(PosterData(it.images.poster[0]+QUERY_POSTER_SIZE, it.summary)) }
            }
        }

        return posterDataList
    }

    /**
     * This method is used as a wrapper to to check whether the response is valid.
     * Validity is determined by response being successful and body not being null.
     * @param - request call returning object of type T wrapped in 'Response' object
     * @return - Object of type T
     */
    private suspend fun <T> execute(request: suspend () -> Response<T>?): T? {
        val response = request()
        response?.let {
            if (it.isSuccessful && it.body() != null) {
                return it.body()
            }
        }

        return null
    }

    companion object {
        private const val QUERY_TITLE = "Kids"
        private const val QUERY_SCREEN_TYPE = "home"
        private const val QUERY_STYLE = "posters"
        private const val QUERY_POSTER_SIZE = "?width=400&height=600"
    }
}