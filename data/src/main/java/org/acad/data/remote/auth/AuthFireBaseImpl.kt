package org.acad.data.remote.auth

import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import com.google.firebase.auth.PhoneAuthProvider.getCredential
import com.google.firebase.auth.PhoneAuthProvider.verifyPhoneNumber
import io.reactivex.rxjava3.core.Completable
import org.acad.domain.model.InvalidCredentialsException
import java.util.concurrent.TimeUnit

/**
 * Created by Acad Bek on 10/5/2023.
 */
class AuthFireBaseImpl : AuthFirebase {

    private val auth = FirebaseAuth.getInstance()

    lateinit var verificationId: String
    lateinit var token: ForceResendingToken
    override fun sendSmsCode(phone: String): Completable = Completable.create {

        val callbacks = object : OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {}

            override fun onVerificationFailed(e: FirebaseException) {
                it.onError(e)
            }

            override fun onCodeSent(
                verificationId: String,
                token: ForceResendingToken
            ) {
                this@AuthFireBaseImpl.verificationId = verificationId
                this@AuthFireBaseImpl.token = token
                it.onComplete()
            }
        }

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phone)
            .setTimeout(60L, TimeUnit.SECONDS)
//            .setActivity(this)
            .setCallbacks(callbacks)
            .build()
        verifyPhoneNumber(options)
    }

    override fun verify(code: String): Completable = Completable.create {
        val credential = getCredential(verificationId, code)

        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
//                    val user = task.result?.user
                    it.onComplete()
                } else {
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        it.onError(InvalidCredentialsException())
                    }
                }
            }
    }

}