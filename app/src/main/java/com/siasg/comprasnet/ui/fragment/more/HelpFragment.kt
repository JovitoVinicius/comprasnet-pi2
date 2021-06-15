package com.siasg.comprasnet.ui.fragment.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.siasg.comprasnet.databinding.FragmentHelpBinding
import com.siasg.comprasnet.ui.adapter.MessageAdapter
import com.siasg.comprasnet.viewmodel.ChatBotViewModel
import java.util.*
import kotlin.random.Random

class HelpFragment : Fragment() {

    private val viewModel: ChatBotViewModel by lazy {
        ViewModelProvider(this).get(ChatBotViewModel::class.java)
    }
    private lateinit var adapter: MessageAdapter
    private lateinit var inputText: TextView
    private lateinit var binding: FragmentHelpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHelpBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inputText = binding.editTextMessage
        adapter = MessageAdapter(requireContext())
        initRecyclerView()
        adapter.addMessage("Sou o chatbot desse app! Como posso te ajudar ?","chat")
        binding.btSendMessage.setOnClickListener {
            sendText()
        }
    }

    private fun initRecyclerView() {
        binding.rvChat.layoutManager = LinearLayoutManager(activity?.applicationContext)
        binding.rvChat.adapter = adapter
    }

    private fun sendText() {
        val message = binding.editTextMessage.text.toString().trim()

        viewModel.verifyEmpty(message) { response ->
            if (response == "OK") {
                adapter.addMessage(message, "USER")
                inputText.text = ""

                val data = Date().toString().substring(0, 10).replace(" ", "")
                val random = Random.nextInt(10000000, 1000000000)
                val sessionId = data + random

                viewModel.sendText(message, "comprasnet@comprasnet-5ba9a.iam.gserviceaccount.com", sessionId) { chatMessage ->
                    adapter.addMessage(chatMessage, "chat")
                }
            }
        }
    }

}