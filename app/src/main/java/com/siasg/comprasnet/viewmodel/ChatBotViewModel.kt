package com.siasg.comprasnet.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.siasg.comprasnet.domain.DialogflowRequest
import com.siasg.comprasnet.interactor.ChatbotInteractor

class ChatBotViewModel (private val app: Application) : AndroidViewModel(app) {
    private val interactor = ChatbotInteractor(app.applicationContext)

    fun sendText(text: String, email: String, sessionId: String, callback: (String) -> Unit) {
        val request = DialogflowRequest(text, email, sessionId)

        interactor.sendText(request) { response ->
            callback(response)
        }
    }

    fun verifyEmpty(text: String, callback: (String) -> Unit) {
        interactor.verifyEmpty(text, callback)
    }
}