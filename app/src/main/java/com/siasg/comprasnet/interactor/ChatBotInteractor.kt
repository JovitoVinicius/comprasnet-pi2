package com.siasg.comprasnet.interactor

import android.content.Context
import com.siasg.comprasnet.domain.DialogflowRequest
import com.siasg.comprasnet.repository.ChatbotRepository

class ChatbotInteractor (context: Context) {
    private val repository = ChatbotRepository(context, "https://comprasnet.herokuapp.com/")

    fun sendText(request: DialogflowRequest, callback: (String) -> Unit) {
        repository.sendText(request, callback)
    }

    fun verifyEmpty(text: String, callback: (String) -> Unit) {
        if (text.isEmpty()) {
            callback("EMPTY")
        } else {
            callback("OK")
        }
    }
}