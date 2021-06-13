package com.siasg.comprasnet.domain

data class ChatbotDTO(
    val queryResult: QueryResult? = null
)
data class QueryResult(
    val fulfillmentText: String? = null
)

class DialogflowRequest (
    val text: String,
    val email: String,
    val sessionId: String
)