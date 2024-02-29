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
    @State var showContent = false
    @State var navigateToHome = false
    
    var body: some View {
        ZStack {
            if navigateToHome {
                HomeScreen()
            } else {
                if showContent {
                    VStack {
                        Image(systemName: "swift")
                            .resizable()
                            .aspectRatio(contentMode: .fill)
                            .frame(width: 200, height: 200)
                            .foregroundColor(.blue)
                        
                        Text(Greeting().greet())
                            .padding(.top, 24)
                    }
                    .transition(AnyTransition.opacity.combined(with: .move(edge: showContent ? .top : .bottom)))
                    .animation(.easeInOut(duration: 0.35), value: showContent)
                }
            }
        }
        .onAppear {
            DispatchQueue.main.asyncAfter(deadline: .now() + 0.5) {
                withAnimation {
                    showContent.toggle()
                }
            }
            
            DispatchQueue.main.asyncAfter(deadline: .now() + 1.5) {
                withAnimation {
                    showContent.toggle()
                }
            }
            
            DispatchQueue.main.asyncAfter(deadline: .now() + 2) {
                withAnimation {
                    navigateToHome.toggle()
                }
            }
        }
    }
}

#Preview {
    SplashScreen()
}
