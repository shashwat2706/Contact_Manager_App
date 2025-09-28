📱 Simple Android Contacts App

A basic Android application that demonstrates how to manage a list of contacts (name and phone number) using modern Android development practices.

This app showcases CRUD operations with local storage using Room, MVVM architecture, Data Binding, and LiveData.

✨ Features

📋 View Contacts – Displays a list of saved contacts.

➕ Add New Contact – Save a new contact with name & phone number.

✏️ Update Contact – Edit an existing contact’s details.

❌ Delete Contact – Remove a selected contact.

🧹 Clear All Contacts – Delete all saved contacts at once.

💾 Data Persistence – Contacts stored locally with Room.

🖇 Data Binding & LiveData – UI updates automatically on data change.

⚡ MVVM Architecture – Clean separation of concerns.

📜 RecyclerView – Efficiently displays the list of contacts.

🏗 Project Structure
app/src/main/java/com/example/contacts/
│── MainActivity.kt               # Main UI controller
│
├── adapter/
│   └── MyRecyclerViewAdapter.kt  # RecyclerView Adapter
│
├── database/
│   ├── Contact.kt                # Data Entity
│   ├── ContactDAO.kt             # DAO interface
│   └── ContactDatabase.kt        # Room Database
│
├── repository/
│   └── ContactRepository.kt      # Data abstraction layer
│
└── viewmodel/
    └── ContactViewModel.kt       # Holds UI data & logic


UI Layouts

res/layout/activity_main.xml – Main screen (input fields, buttons, RecyclerView)

res/layout/item_contact.xml – Layout for each contact row

🏛 Architecture – MVVM

Model → Room Database (Contact, ContactDAO, ContactDatabase, ContactRepository)

View → UI Layer (MainActivity, XML layouts, RecyclerView)

ViewModel → ContactViewModel (exposes LiveData to UI, handles user actions)

⚙️ Tech Stack

Kotlin – Primary language

Android Jetpack Components:

Room (local persistence)

ViewModel (UI-related data)

LiveData (reactive data updates)

Data Binding (connects UI ↔ ViewModel)

Coroutines – Asynchronous DB operations

RecyclerView – List rendering

Material Components – UI styling

🚀 How It Works

Database Setup – ContactDatabase provides ContactDAO for CRUD operations.

User Actions – MainActivity calls ContactViewModel methods when buttons are clicked.

Business Logic – ContactViewModel interacts with ContactRepository.

Data Persistence – Repository updates Room DB.

Reactive Updates – LiveData notifies UI → RecyclerView updates instantly.

▶️ Getting Started

Clone the repository:

git clone https://github.com/your-username/contacts-app.git
cd contacts-app


Open in Android Studio.

Build the project and run it on an emulator or device.

📸 Screenshots (Optional)

(Add screenshots of your app UI here for better presentation)

📜 License

This project is licensed under the MIT License – feel free to use and modify it.
