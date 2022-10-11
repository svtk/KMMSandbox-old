//
//  GreetingsState.swift
//  iosApp
//
//  Created by Svetlana.Isakova on 01.11.22.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

class GreetingsState: ObservableObject {
    let viewModel: GreetingViewModel
    
    @Published var greetings: [String]  = []
    
    init() {
        viewModel = GreetingViewModel()
         
        viewModel.observeGreetings { greetings in
            self.greetings = greetings
        }
    }
    
    deinit {
        viewModel.clear()
    }
}
