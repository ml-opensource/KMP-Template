//
//  SplashScreen.swift
//  iosApp
//
//  Created by Golam Shakib Khan on 27/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import ComposeApp

struct SplashScreen: View {
    @State var viewModel = SplashViewModelProvider().provide()
    @State var screenState: SplashScreenState = SplashScreenState()
    @State var navigate = false
    
    var body: some View {
        ZStack {
            if navigate && screenState.user != nil {
                HomeScreen()
            } else if navigate && screenState.user == nil {
                LoginScreen()
            } else {
                VStack {
                    Image(systemName: "swift")
                        .resizable()
                        .aspectRatio(contentMode: .fill)
                        .frame(width: 200, height: 200)
                        .foregroundColor(.blue)
                    
                    Text(screenState.greeting)
                        .padding(.top, 24)
                }
                .transition(AnyTransition.opacity.combined(with: .move(edge: .top)))
                .animation(.easeInOut(duration: 0.35), value: screenState.showContent)
            }
        }
        .onAppear {
            DispatchQueue.main.asyncAfter(deadline: .now() + 0.5) {
                withAnimation {
                    viewModel.handleIntent(intent: SplashScreenIntent.OnContentVisibilityChange(show: true))
                }
            }
            
            DispatchQueue.main.asyncAfter(deadline: .now() + 1.5) {
                withAnimation {
                    viewModel.handleIntent(intent: SplashScreenIntent.OnContentVisibilityChange(show: false))
                }
            }
            
            DispatchQueue.main.asyncAfter(deadline: .now() + 2) {
                withAnimation {
                    navigate.toggle()
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
    SplashScreen()
}
