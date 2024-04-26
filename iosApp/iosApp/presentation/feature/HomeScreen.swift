//
//  HomeScreen.swift
//  iosApp
//
//  Created by Golam Shakib Khan on 27/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import ComposeApp

struct HomeScreen: View {
    var viewModel = HomeViewModel()

    var body: some View {
        NavigationView {
            ZStack {
                ScrollView(showsIndicators: false) {
                    VStack(alignment: .leading) {
                        ForEach(viewModel.state.productList, id: \.id) { product in
                            Text(product.title)
                        }
                    }
                }
                
                if viewModel.state.isLoading {
                    ProgressView()
                }
            }
            .navigationBarTitleDisplayMode(.inline)
            .navigationTitle("Home")
            .onAppear {
                viewModel.handleIntent(intent: HomeScreenIntent.OnLaunch())
            }
        }
    }
}

#Preview {
    HomeScreen()
}
