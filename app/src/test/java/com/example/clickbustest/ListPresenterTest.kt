package com.example.clickbustest

import com.example.clickbustest.data.Movie
import com.example.clickbustest.ui.list.ListPresenter
import com.example.clickbustest.ui.list.ListView
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ListPresenterTest {

    @Mock
    lateinit var mockListPresenter: ListPresenter

    @Mock
    lateinit var mocklistview: ListView

    private var list: List<Movie>? = null

    lateinit var listPresenter: ListPresenter

    @Before
    fun setUpTest() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun test() {
        listPresenter = ListPresenter()
        Mockito.`when`(mockListPresenter.getNextPage(1) ).thenReturn(list)
        listPresenter.getNextPage(1)


        verify(mocklistview).showList()

    }
}

private fun Any.thenReturn(list: List<Movie>?) {

}
