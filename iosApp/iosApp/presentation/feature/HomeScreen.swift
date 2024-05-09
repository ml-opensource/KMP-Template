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
    @State var viewModel = HomeViewModelProvider().provide()
    @State var screenState: HomeScreenState = HomeScreenState()
    
    var body: some View {
        NavigationView {
            ZStack {
                ScrollView(showsIndicators: false) {
                    VStack(alignment: .leading) {
                        ForEach(screenState.productList, id: \.id) { product in
                            ProductItemView(product: product)
                        }
                    }
                }
                
                if screenState.isLoading {
                    ProgressView()
                }
            }
            .navigationBarTitleDisplayMode(.inline)
            .navigationTitle("Products")
            .onAppear {
                viewModel.handleIntent(intent: HomeScreenIntent.OnLaunch())
            }
            .task {
                for await state in viewModel.state {
                    screenState = state
                }
            }
        }
    }
}

struct ProductItemView: View {
    let product: Product
    
    var body: some View {
        ZStack {
            AsyncImage(url: URL(string: product.thumbnail)) { image in
                image.image?
                    .resizable()
                    .scaledToFill()
            }
            .cornerRadius(8.0)
            
            VStack {
                Spacer()
                
                Text(product.title)
                    .foregroundColor(.white)
                    .frame(maxWidth: .infinity)
                    .padding(8.0)
            }
            .background(LinearGradient(gradient: Gradient(colors: [Color.black, Color.gray.opacity(0.2)]), startPoint: .bottom, endPoint: .center))
            .cornerRadius(8.0)
        }
        .padding(.horizontal, 8)
        .padding(.vertical, 2)
    }
}

#Preview {
    HomeScreen()
}
