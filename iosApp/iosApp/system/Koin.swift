//
//  Koin.swift
//  iosApp
//
//  Created by Golam Shakib Khan on 27/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import ComposeApp

final class Koin {
  private var core: Koin_coreKoin?
  
  static let instance = Koin()
  
  static func start() {
    if instance.core == nil {
      let app = KoinIOS.shared.initialize()
      instance.core = app.koin
    }
    if instance.core == nil {
      fatalError("Can't initialize Koin.")
    }
  }
  
  private init() {
    
  }
  
  func get<T: AnyObject>() -> T {
    guard let core = core else {
      fatalError("You should call `start()` before using \(#function)")
    }
    
    guard let result = core.get(objCClass: T.self) as? T else {
      fatalError("Koin can't provide an instance of type: \(T.self)")
    }
    
    return result
  }
}
