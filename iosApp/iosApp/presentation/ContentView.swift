import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

/**
 Entry point for the iOS App.
 
 Uncomment the line
 ```
 SplashScreen()
 ```
 and comment out the line
 ```
 ComposeView().ignoresSafeArea(.keyboard)
 ```
 to run the app in Swift UI.
 */
struct ContentView: View {
    var body: some View {
        // SplashScreen()
        ComposeView().ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}



