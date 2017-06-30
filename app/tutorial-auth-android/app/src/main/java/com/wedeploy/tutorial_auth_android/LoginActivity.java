package com.wedeploy.tutorial_auth_android;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.wedeploy.android.Callback;
import com.wedeploy.android.auth.Authorization;
import com.wedeploy.android.auth.ProviderAuthorization;
import com.wedeploy.android.auth.TokenAuthorization;
import com.wedeploy.android.transport.Response;
import com.wedeploy.tutorial_auth_android.databinding.LoginActivityBinding;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class LoginActivity extends BaseActivity {

	private LoginActivityBinding binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);


		binding = DataBindingUtil.setContentView(this, R.layout.login_activity);

		binding.goToSignUp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
			}
		});

		binding.login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String email = binding.email.getText().toString();
				String password = binding.password.getText().toString();

				if (!email.isEmpty() && !password.isEmpty()) {
					doLogin(email, password);
				} else {
					Toast.makeText(LoginActivity.this, "You have to fill all the fields",
						Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	private void doLogin(String email, String password) {
		// Add the code of the tutorial below
		weDeploy.auth("auth.inovant-weread.wedeploy.io")
				.signIn(email, password).execute(new Callback() {
			@Override
			public void onSuccess(Response response) {
				showAlert("Success", "Signed in");
			}

			@Override
			public void onFailure(Exception e) {
				showAlert("Error", "Login error");
			}
		});
		// -------
	}
}
