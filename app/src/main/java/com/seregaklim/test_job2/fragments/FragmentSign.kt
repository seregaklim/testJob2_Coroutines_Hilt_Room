package com.seregaklim.fragments

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.seregaklim.data.AuthRequest
import com.seregaklim.data.ErrorUserToken
import com.seregaklim.test_job2.R
import com.seregaklim.test_job2.databinding.FragmentSignBinding
import com.seregaklim.test_job2.viewmodel.ErorSignViewModel
import com.seregaklim.utils.AndroidUtils
import com.seregaklim.viewmodel.SignViewModel
import dagger.hilt.android.AndroidEntryPoint


@Suppress("DEPRECATION")
@AndroidEntryPoint
class SignFragment  () : Fragment() {

    private lateinit var binding: FragmentSignBinding
    private var actionLogin: String? = null
    private var pass1: String? = null
    private var pass2: String? = null
    private var pass3: String? = null
    private var pass4: String? = null
    private var pass5: String? = null
    private var password: String? = null


    private val signViewModel: SignViewModel by activityViewModels()
    private val erorSignViewModel: ErorSignViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentSignBinding.inflate(
            inflater,
            container,
            false
        )
        signEror()
        sign()
        uiButtons()

        return binding.root
    }

fun uiButtons(){
    actionLogin = binding.tvTextLogin.text.toString()
    binding.tvTextLogin.setText(actionLogin)

    binding.tvTextLogin.setOnClickListener() {
        erorSignViewModel.dataErorAuth.value= ErrorUserToken("","")

    }

    binding.bTextLogin.setOnClickListener() {
        erorSignViewModel.dataErorAuth.value= ErrorUserToken("","")
    }


    binding.tvPassUser.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->

        if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {

            val pass = binding.tvPassUser.text.toString()

            textPass(pass)
            return@OnKeyListener false
        }

        if (keyCode == KeyEvent.KEYCODE_1 && event.action == KeyEvent.ACTION_UP) {

            val pass = binding.tvPassUser.text.toString()
            textPass(pass)
            return@OnKeyListener true
        }


        if (keyCode == KeyEvent.KEYCODE_2 && event.action == KeyEvent.ACTION_UP) {

            val pass = binding.tvPassUser.text.toString()
            textPass(pass)
            return@OnKeyListener true
        }

        if (keyCode == KeyEvent.KEYCODE_3 && event.action == KeyEvent.ACTION_UP) {

            val pass = binding.tvPassUser.text.toString()
            textPass(pass)

            return@OnKeyListener true
        }

        if (keyCode == KeyEvent.KEYCODE_4 && event.action == KeyEvent.ACTION_UP) {

            val pass = binding.tvPassUser.text.toString()
            textPass(pass)

            return@OnKeyListener true
        }


        if (keyCode == KeyEvent.KEYCODE_5 && event.action == KeyEvent.ACTION_UP) {

            val pass = binding.tvPassUser.text.toString()
            textPass(pass)

            return@OnKeyListener true
        }

        if (keyCode == KeyEvent.KEYCODE_6 && event.action == KeyEvent.ACTION_UP) {

            val pass = binding.tvPassUser.text.toString()
            textPass(pass)

            return@OnKeyListener true
        }

        if (keyCode == KeyEvent.KEYCODE_7 && event.action == KeyEvent.ACTION_UP) {

            val pass = binding.tvPassUser.text.toString()
            textPass(pass)

            return@OnKeyListener true
        }

        if (keyCode == KeyEvent.KEYCODE_8 && event.action == KeyEvent.ACTION_UP) {

            val pass = binding.tvPassUser.text.toString()
            textPass(pass)

            return@OnKeyListener true
        }

        if (keyCode == KeyEvent.KEYCODE_9 && event.action == KeyEvent.ACTION_UP) {

            val pass = binding.tvPassUser.text.toString()
            textPass(pass)

            return@OnKeyListener true
        }

        if (keyCode == KeyEvent.KEYCODE_0 && event.action == KeyEvent.ACTION_UP) {

            val pass = binding.tvPassUser.text.toString()
            textPass(pass)

            return@OnKeyListener true
        }

        false
    })

    binding.bContstraintEnter.setOnClickListener {

        if (actionLogin == null) {
            binding.tvPassText.setText(R.string.your_login_is_too_small)
            binding.loginBordur.setBackgroundResource(R.drawable.red_border)
            return@setOnClickListener
        }

        if (password == null) {
            binding.linearPass1color.setBackgroundResource(R.drawable.red_border)
            binding.tvPassText.setText(R.string.enter_the_password)
        }

        if (password != null) {
            val authRequest = AuthRequest(binding.tvTextLogin.text.toString(), password!!)
            signViewModel.sigAuth(authRequest)
            erorSignViewModel.sigAuthEror(authRequest)
        }
    }
}


    //работаем с текстом номера
    fun textPass(pass: String) {
        binding.linearPass1color.setBackgroundResource(R.drawable.black_border)
        binding.tvPassText.setTextColor(resources.getColor(R.color.black))

        val result = pass.filter { it.isDigit() }

        if (result.length == 1) {
            pass1 = result
            binding.tvPassUser.setText("${result} __ __ __ __ __")
            binding.tvPassUser.setSelection(3)
        }

        if (result.length == 2) {
            val resultN = result[1]
            pass2 = resultN.toString()
            binding.tvPassUser.setText("${pass1} ${pass2} __ __ __ __")
            binding.tvPassUser.setSelection(5)
        }

        if (result.length == 3) {
            val resultN = result[2]
            pass3 = resultN.toString()
            binding.tvPassUser.setText("${pass1} ${pass2} ${pass3} __ __ __")
            binding.tvPassUser.setSelection(7)
        }


        if (result.length == 4) {
            val resultN = result[3]
            pass4 = resultN.toString()
            binding.tvPassUser.setText("${pass1} ${pass2} ${pass3} ${pass4} __ __")
            binding.tvPassUser.setSelection(9)
        }

        if (result.length == 5) {
            val resultN = result[4]
            pass5 = resultN.toString()
            binding.tvPassUser.setText("${pass1} ${pass2} ${pass3} ${pass4} ${pass5}")
            //весь pass
            password = "${pass1}${pass2}${pass3}${pass4}${pass5}"

          AndroidUtils.hideKeyboard(requireView())
        }

        if (result.length > 5) {
            val resultN = result[4]
            pass5 = resultN.toString()

            binding.tvPassUser.setText("${pass1} ${pass2} ${pass3} ${pass4} ${pass5}")
            //весь pass
            password = "${pass1}${pass2}${pass3}${pass4}${pass5}${pass5}"

            AndroidUtils.hideKeyboard(requireView())
        }


    }
    fun signEror() {
        erorSignViewModel.dataErorAuth.observe(viewLifecycleOwner) {
            Log.d("MyLog", "erorSignViewModel ${it}")
            if (it.error_code == "1003") {
                binding.tvPassText.setText(R.string.User_authorization_failed)
                binding.loginBordur.setBackgroundResource(R.drawable.red_border)
                binding.linearPass1color.setBackgroundResource(R.drawable.red_border)
                binding.tvPassText.setTextColor(resources.getColor(R.color.red))
            }

            if (it.error_code != "1003") {
                binding.tvPassText.setText(R.string.enter_your_authorization_number)
                binding.loginBordur.setBackgroundResource(R.drawable.black_border)
                binding.linearPass1color.setBackgroundResource(R.drawable.black_border)
                binding.tvPassText.setTextColor(resources.getColor(R.color.black))
            }
        }
    }

    fun sign() {
        signViewModel.tokenData.observe(viewLifecycleOwner) {
            if (it!= null) {
                findNavController().navigate(R.id.action_signFragment_to_fragmentResponse)
            }
        }
    }


}