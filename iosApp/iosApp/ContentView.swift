import SwiftUI
import shared
import KMPNativeCoroutinesAsync

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel

    var body: some View {
        List(viewModel.phrases, id: \.self) {
            Text($0)
        }
    }
}

extension ContentView {
    @MainActor
    class ViewModel: ObservableObject {
        @Published var phrases = [String]()
        init() {
            Task {
                do {
                    let stream = asyncStream(for: Greeting().greetingNative())
                    for try await data in stream {
                        self.phrases = data
                    }
                } catch {
                    print("Failed with error: \(error)")
                }
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(viewModel: ContentView.ViewModel())
    }
}
