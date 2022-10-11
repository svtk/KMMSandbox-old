import SwiftUI
import shared
import KMPNativeCoroutinesAsync

struct GreetingsView: View {
    @ObservedObject var state: GreetingsState

    var body: some View {
        List(state.greetings, id: \.self) {
            Text($0)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        GreetingsView(state: GreetingsState())
    }
}
