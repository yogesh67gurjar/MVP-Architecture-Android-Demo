# MVP Architecture Demo - Android App

![1_TuWeZzR14MmB-RBbjtZl-A](https://github.com/user-attachments/assets/f2fc6c41-c4e2-4a53-9434-c56c51edbc87)

This is a simple Android app demonstrating the **Model-View-Presenter (MVP)** architecture. The app fetches random cat facts from [CatFact API](https://catfact.ninja/) and displays them to the user.

## Features
- **API Integration**: Retrieves random cat facts from the CatFact API.
- **MVP Architecture**: Implements the MVP pattern for better separation of concerns.
- **User Interface**: Simple UI with a button to fetch cat facts and a text view to display them.

## Project Structure
- **Contract**: Defines the `View` and `Presenter` interfaces.
- **Presenter**: Contains the `MainPresenter` class, which handles the business logic and API interactions.
- **View**: Contains the `MainActivity` class, which implements the `View` interface and handles user interactions.

## MVP Architecture Explanation

### Components in the Code

1. **Contract**:
   - This interface defines the contract between the `View` and the `Presenter`.
   - **Responsibilities**:
     - **View**: Specifies methods that the `Presenter` will call to update the UI (like showing/hiding progress and displaying success or failure messages).
     - **Presenter**: Specifies methods that the `View` will invoke to interact with the presenter (like fetching data).

2. **Presenter (`MainPresenter`)**:
   - Implements the `Contract.Presenter` interface and handles the business logic.
   - **Responsibilities**:
     - Makes API calls to fetch data.
     - Processes the API response and communicates results back to the `View`.
     - Calls methods on the `View` to show/hide progress indicators based on the API request state.

3. **View (`MainActivity`)**:
   - Implements the `Contract.View` interface and serves as the UI component of the application.
   - **Responsibilities**:
     - Displays the user interface and interacts with the user.
     - Calls the `Presenter` methods based on user actions (e.g., clicking a button to fetch data).
     - Updates the UI based on the results received from the `Presenter`.

### Summary of MVP Roles:
- **Model**: Implicitly represented by the API (`ApiService`) and the `CatFactResponse` data class.
- **View**: `MainActivity` handles user interactions and displays data.
- **Presenter**: `MainPresenter` contains the business logic and updates the UI accordingly.

## How to Run
1. Clone this repository.
2. Open the project in Android Studio.
3. Build and run the app on an emulator or a real device.
4. Click the button to fetch a random cat fact.

## Libraries Used
- **Retrofit**: For networking and API calls.
- **Gson**: For parsing JSON responses.

## API Reference
- [CatFact API](https://catfact.ninja/)

## Contact
- **Email**: [yogesh67gurjar@gmail.com](mailto:yogesh67gurjar@gmail.com)
- **GitHub**: [github.com/yogesh67gurjar](https://github.com/yogesh67gurjar)
