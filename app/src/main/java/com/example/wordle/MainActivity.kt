package com.example.wordle

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.wordle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        keepPassingFocus()

        // Once end of row 2 is reach check to see if user guessed the word
        binding.edt14.addTextChangedListener {
            validateRow(
                binding.edt11,
                binding.edt12,
                binding.edt13,
                binding.edt14
            )
        }

        // Once end of row 2 is reach check to see if user guessed the word
        binding.edt24.addTextChangedListener {
            validateRow(
                binding.edt21,
                binding.edt22,
                binding.edt23,
                binding.edt24
            )
        }

        // Once end of row 3 is reach check to see if user guessed the word
        binding.edt34.addTextChangedListener {
            validateRow(
                binding.edt31,
                binding.edt32,
                binding.edt33,
                binding.edt34
            )
        }
    }

    // Function checks to see if user guessed word correctly after each attempt
    private fun validateRow(
        edt1: EditText,
        edt2: EditText,
        edt3: EditText,
        edt4: EditText
    ){
        // Get user input from text block
        val edt1Text = edt1.text.toString()
        val edt2Text = edt2.text.toString()
        val edt3Text = edt3.text.toString()
        val edt4Text = edt4.text.toString()

        // Split word
        val word1 = WORD[0].toString()
        val word2 = WORD[1].toString()
        val word3 = WORD[2].toString()
        val word4 = WORD[3].toString()

        // If guess is correct make block yellow
        if(edt1Text == word2 || edt1Text == word3 || edt1Text == word4){
            edt1.setBackgroundColor(Color.parseColor("#ffff00"))
        }

        // If guess is correct make block yellow
        if(edt2Text == word1 || edt2Text == word3 || edt2Text == word4) {
            edt2.setBackgroundColor(Color.parseColor("#ffff00"))
        }

        // If guess is correct make block yellow
        if(edt3Text == word1 || edt3Text == word2 || edt3Text == word4) {
            edt3.setBackgroundColor(Color.parseColor("#ffff00"))
        }

        // If guess is correct make block yellow
        if(edt4Text == word1 || edt4Text == word2 || edt4Text == word3) {
            edt4.setBackgroundColor(Color.parseColor("#ffff00"))
        }

        // If guess is correct make block green
        if (edt1Text == word1){
            edt1.setBackgroundColor(Color.parseColor("#33cc33"))
        }

        // If guess is correct make block green
        if (edt2Text == word2){
            edt2.setBackgroundColor(Color.parseColor("#33cc33"))
        }

        // If guess is correct make block green
        if (edt3Text == word3){
            edt3.setBackgroundColor(Color.parseColor("#33cc33"))
        }

        // If guess is correct make block green
        if (edt4Text == word4){
            edt4.setBackgroundColor(Color.parseColor("#33cc33"))
        }

        // If guess is correct make block red
        if(edt1Text != word1 && edt1Text != word2 && edt1Text != word3
            && edt1Text != word4){
            edt1.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        // If guess is correct make block red
        if(edt2Text != word1 && edt2Text != word2 && edt2Text != word3
            && edt2Text != word4){
            edt2.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        // If guess is correct make block red
        if(edt3Text != word1 && edt3Text != word2 && edt3Text != word3
            && edt3Text != word4){
            edt3.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        // If guess is correct make block red
        if(edt4Text != word1 && edt4Text != word2 && edt4Text != word3
            && edt4Text != word4){
            edt4.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        // Checks if user has won game if not print winning message
        if(edt1Text == word1 && edt2Text == word2 && edt3Text == word3 && edt4Text == word4){
            Toast.makeText(this, "Congrats!! You guessed the word!", Toast.LENGTH_SHORT).show()
            binding.txtWinnerLoser.visibility = View.VISIBLE
            binding.txtWinnerLoser.text = "Congrats!! You guessed the word!"
            makeGameInactive()
            return
            }

        // Checks if user has won game if not print losing message
        if (edt4.id == R.id.edt_34){
            Toast.makeText(this, "Sorry you did not guess the word", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, WORD, Toast.LENGTH_LONG).show()
            binding.txtWinnerLoser.visibility = View.VISIBLE
            binding.txtWinnerLoser.text = "Sorry you did not guess the word"
            makeGameInactive()
            return
        }
        }

        //Disable game after user wins or uses all their guesses
        private fun makeGameInactive(){
            binding.edt11.isEnabled = false
            binding.edt12.isEnabled = false
            binding.edt13.isEnabled = false
            binding.edt14.isEnabled = false

            binding.edt21.isEnabled = false
            binding.edt22.isEnabled = false
            binding.edt23.isEnabled = false
            binding.edt24.isEnabled = false

            binding.edt31.isEnabled = false
            binding.edt32.isEnabled = false
            binding.edt33.isEnabled = false
            binding.edt34.isEnabled = false
    }

    //Function to go to next block in a row
    private fun keepPassingFocus(){
        passFocus(binding.edt11, binding.edt12)
        passFocus(binding.edt12, binding.edt13)
        passFocus(binding.edt13, binding.edt14)

        passFocus(binding.edt21, binding.edt22)
        passFocus(binding.edt22, binding.edt23)
        passFocus(binding.edt23, binding.edt24)

        passFocus(binding.edt31, binding.edt32)
        passFocus(binding.edt32, binding.edt33)
        passFocus(binding.edt33, binding.edt34)
    }

    // Function to go to next text block
    private fun passFocus(edt1: EditText, edt2: EditText){
        edt1.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(edt: Editable?) {
                if(edt?.length == 1){
                    edt2.requestFocus()
                }
            }

        })
    }

    // Word user will guess
    companion object{
        private val WORD = "bone"
    }
}