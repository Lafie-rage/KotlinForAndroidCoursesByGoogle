package com.example.affirmationsapp

import android.content.Context
import com.example.affirmationsapp.adapter.ItemAdapter
import com.example.affirmationsapp.model.Affirmation
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock

class AffirmationAdapterTests {
    private val context = mock(Context::class.java) // I didn't used the context but to keep track of how to get context in unit tests, I let this line

    @Test
    fun adapter_size() {
        val data = listOf(
            Affirmation(R.string.affirmation1, R.drawable.image1),
            Affirmation(R.string.affirmation2, R.drawable.image2),
        )

        val adapter = ItemAdapter(data)

        assertEquals("ItemAdapter is not the correct size", data.size, adapter.itemCount)
    }
}