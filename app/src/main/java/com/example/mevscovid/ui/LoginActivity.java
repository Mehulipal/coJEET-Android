package com.example.mevscovid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mevscovid.R;
import com.example.mevscovid.ui.gallery.GalleryFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {


    EditText emailId;

    EditText password;

    TextView tvLogin;

    FirebaseAuth mFirebaseAuth;

    Button btnLogin;

    private FirebaseAuth.AuthStateListener mAuthStateListener;

    /** @Override protected void onCreate(Bundle savedInstanceState) {
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login);

    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
    actionBar.hide();
    }

    mAuth = ((FirebaseApplication) getApplication()).getFirebaseAuth();
    ((FirebaseApplication) getApplication()).checkUserLogin(LoginActivity.this);

    loginError = (TextView) findViewById(R.id.login_error);

    emailInput = (EditText) findViewById(R.id.email);
    passwordInput = (EditText) findViewById(R.id.password);

    signUpText = (TextView) findViewById(R.id.register);
    signUpText.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View view) {
    Intent signUpIntent = new Intent(LoginActivity.this, SignUpActivity.class);
    startActivity(signUpIntent);
    }
    });

    final Button loginButton = (Button) findViewById(R.id.login_button);
    loginButton.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View view) {
    String enteredEmail = emailInput.getText().toString();
    String enteredPassword = passwordInput.getText().toString();

    if (TextUtils.isEmpty(enteredEmail) || TextUtils.isEmpty(enteredPassword)) {
    Toast.makeText(LoginActivity.this, "Login fields must be filled", Toast.LENGTH_SHORT);
    return;
    }**/
    /**if (!Helper.isValidEmail(enteredEmail)) {
     Toast.makeText(LoginActivity.this, "Invalidate email entered",Toast.LENGTH_SHORT);
     return;
     }**/

    /**
     * ((FirebaseApplication) getApplication()).loginAUser(LoginActivity.this, enteredEmail, enteredPassword, loginError);
     * }
     * });
     * }
     *
     * @Override public void onStart() {
     * super.onStart();
     * //mAuth.addAuthStateListener(((FirebaseApplication)getApplication()).mAuthListener);
     * }
     * @Override public void onStop() {
     * super.onStop();
     * if (((FirebaseApplication) getApplication()).mAuthListener != null) {
     * //mAuth.removeAuthStateListener(((FirebaseApplication)getApplication()).mAuthListener);
     * }
     * }
     **/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.login_button);
        tvLogin = findViewById(R.id.register);
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(LoginActivity.this, "You are logged in", Toast.LENGTH_SHORT);
                    Intent i = new Intent(LoginActivity.this, GalleryFragment.class);
                    startActivity(i);
                } else {
                    Toast.makeText(LoginActivity.this, "Please Login", Toast.LENGTH_SHORT);
                }
            }
        };

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if (email.isEmpty()) {
                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("Please enter your password");
                    password.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Fields are Empty", Toast.LENGTH_SHORT);
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "Login Error,Please Try Again", Toast.LENGTH_SHORT);
                            } else {
                                startActivity(new Intent(LoginActivity.this, GalleryFragment.class));
                            }
                        }
                    });

                } else {
                    Toast.makeText(LoginActivity.this, "Error Occured", Toast.LENGTH_SHORT);

                }
            }

        });
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });
    }
        @Override
        protected void onStart () {
            super.onStart();
            mFirebaseAuth.addAuthStateListener(mAuthStateListener);
        }
    }









