package iu.c323.fall2024.practicum18.network

import androidx.paging.PagingSource
import androidx.paging.PagingState

class PhotoPagingSource(
    private val photoService: Flicker
) : PagingSource<Int, GalleryItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GalleryItem> {
        return try {
            val currentPage = params.key ?: 1
            val response = photoService.fetchPhotos(page = currentPage, pageSize = params.loadSize)

            LoadResult.Page(
                data = response.photos.photos,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (response.photos.photos.isEmpty()) null else currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, GalleryItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}

