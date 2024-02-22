package com.example.latihan_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.latihan_1.databinding.ActivitySecondBinding
import com.google.firebase.auth.FirebaseAuth


class SecondActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportActionBar?.hide()


        binding =ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.firebaseAuth = FirebaseAuth.getInstance()

        binding.TvKlikReg.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.TIEemail.toString()
            val pass = binding.TIEPassword.toString()


            if (email.isNotEmpty() && pass.isNotEmpty()) {

                    firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }

            } else {
                Toast.makeText(this, "Password Salah", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }


//        val btnLogin = findViewById<Button>(R.id.btnLogin)
//        val TvKlikReg = findViewById<TextView>(R.id.TvKlikReg)
//        btnLogin.setOnClickListener(this)
//        TvKlikReg.setOnClickListener(this)

}

//    override fun onClick(v: View?){
//        when(v?.id){
//            R.id.btnLogin -> {
//                val btnLoginIntent = Intent(this@SecondActivity, HomeActivity::class.java)
//                startActivity(btnLoginIntent)
//            }
//            R.id.TvKlikReg -> {
//                val btnRegisterIntent = Intent(this@SecondActivity, RegisterActivity::class.java)
//                startActivity(btnRegisterIntent)
//            }
//        }
//    }
//}