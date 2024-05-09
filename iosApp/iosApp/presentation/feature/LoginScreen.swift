//
//  LoginScreen.swift
//  iosApp
//
//  Created by Golam Shakib Khan on 7/5/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import ComposeApp

struct LoginScreen: View {
    @State var viewModel = LoginViewModelProvider().provide()
    @State var screenState: LoginScreenState = LoginScreenState()
    
    var body: some View {
        ZStack {
            if screenState.isLoggedIn {
                HomeScreen()
            } else {
                VStack {
                    TextField("Email", text: $screenState.email)
                        .padding()
                        .overlay(
                            RoundedRectangle(cornerRadius: 4)
                                .stroke(.gray, lineWidth: 1)
                        )
                        .padding(.horizontal)
                    
                    SecureField("Password", text: $screenState.password)
                        .padding()
                        .overlay(
                            RoundedRectangle(cornerRadius: 4)
                                .stroke(.gray, lineWidth: 1)
                        )
                        .padding(.horizontal)
                    
                    Button(action: {
                        viewModel.handleIntent(intent: LoginIntent.Login())
                    }, label: {
                        if screenState.isLoading {
                            ProgressView()
                        } else {
                            Text("Login")
                                .font(.headline)
                                .foregroundColor(.black)
                        }
                    })
                    .frame(maxWidth: .infinity, maxHeight: 48)
                    .background(.yellow)
                    .cornerRadius(8)
                    .padding(.horizontal)
                    .padding(.vertical)
                }
            }
        }
        .task {
            for await state in viewModel.state {
                screenState = state
            }
        }
    }
}

#Preview {
    LoginScreen()
}
