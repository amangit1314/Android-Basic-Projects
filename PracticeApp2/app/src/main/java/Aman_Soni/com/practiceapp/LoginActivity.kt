package Aman_Soni.com.practiceapp

import Aman_Soni.com.PracticeApp.R
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() , View.OnClickListener{

    lateinit var etMobileNumber: EditText
    lateinit var etPassword : EditText
    lateinit var btLogIn : Button
    lateinit var txtForgot : TextView
    lateinit var txtRegister : TextView
    val validMobileNumber  = "123456789"
    val validPassword = arrayOf("charizard","blastoise","venusaur","arceus")
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)

        if(isLoggedIn){
            val intent  = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        
        title = "Log In"

        etMobileNumber  = findViewById((R.id.etMobileNumber))
        etPassword = findViewById((R.id.etPassword))
        btLogIn = findViewById(R.id.btLogIn)
        txtForgot = findViewById(R.id.txtForgot)
        txtRegister = findViewById(R.id.txtRegister)



        btLogIn.setOnClickListener{
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            var nameOfPokemon = "Pokemon"
            val intent = Intent(this@LoginActivity , MainActivity::class.java)
            startActivity(intent)
               if (((mobileNumber == validMobileNumber)))
               {
                   savePreferences(nameOfPokemon)

                   if(password == validPassword[0]) {
                       nameOfPokemon = "Charizard"
                       savePreferences(nameOfPokemon)

                       startActivity(intent)
                   }

                   else if(password == validPassword[1]) {
                       nameOfPokemon = "Blastoise"
                       savePreferences(nameOfPokemon)

                       startActivity(intent)
                   }

                   else if(password == validPassword[2]){
                       nameOfPokemon = "Venusaur"
                       savePreferences(nameOfPokemon)

                       startActivity(intent)
                   }

                   else if(password == validPassword[3]){
                       nameOfPokemon = "Arceus"
                       savePreferences(nameOfPokemon)

                       startActivity(intent)
                   }

                   else if(password == validPassword[4]){
                       nameOfPokemon = "Mewtwo"
                       savePreferences(nameOfPokemon)

                       startActivity(intent)
                   }
               }
            else{
                   Toast.makeText(this@LoginActivity, "Incorrect Credentials", Toast.LENGTH_LONG).show()
               }
            }
    }

    override fun onClick(p0: View?) {

    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    private fun savePreferences(title : String){
        sharedPreferences.edit().putBoolean("isLogedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}
