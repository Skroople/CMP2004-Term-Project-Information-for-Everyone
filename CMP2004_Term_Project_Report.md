# CMP2004 Advanced Programming - Term Project Report

**Project Title:** Information for Everyone (Supportive Information App)
**Student Name(s):** Mehmet Eren Ekşi, Yiğit Erel
**Student ID(s):** 2364932, 2483739
**Selected Project Option:** Option 3: Supportive Information App

---

## 1. Purpose of the App
The purpose of this application is to provide disadvantaged individuals with a highly accessible, free, and easy-to-use platform to obtain critical information. The app serves as a digital guide, offering curated advice and resources across three vital categories: Health Information, Legal Rights, and Social Support. By prioritizing an accessible interface, it ensures that users who may have technical or cognitive barriers can still easily access the help they need.

## 2. Main Features
- **Category-Based Navigation:** Information is divided into distinct, easily identifiable categories (Health, Legal, Social) using large icons and clear text.
- **Real-Time "Tip of the Day":** The application connects to a live internet API to fetch and display dynamic, real-time advice on the category pages.
- **System Notifications:** An automated background service triggers a system notification to remind users of daily tips and resources.
- **Accessibility & Material Design:** Utilizes Material Design 3 principles, including elevated CardViews, smooth list animations, and high-contrast color palettes for maximum readability.
- **Emergency and Feedback Tools:** Includes one-tap access to emergency services (112) and an integrated email intent system for user feedback.

## 3. Technical Structure
The application was developed in Android Studio using Java, targeting Android API Level 36. Its technical foundation includes:
- **Object-Oriented Design:** Employs a structured architecture utilizing Models (`InfoCategory`, `InfoItem`), an Adapter (`InfoItemAdapter`), and a Singleton repository (`InfoRepository`) for local data management.
- **Multiple Activities & Intents:** Contains 5 distinct activities managed with proper lifecycle awareness. Navigation is handled via explicit intents with custom transition animations.
- **Networking:** Implements an asynchronous HTTP request using `HttpURLConnection` (via `HttpRequestTask`) to fetch JSON data from `api.adviceslip.com/advice` without blocking the main UI thread.
- **Background Services:** Uses a standard Android `Service` (`TipNotificationService`) coupled with a `BroadcastReceiver` (`BootReceiver`) to handle system-level notifications.
- **Modern Permissions:** Implements dynamic runtime permissions (`ActivityCompat.requestPermissions`) to properly handle the `POST_NOTIFICATIONS` requirement introduced in recent Android versions.

## 4. Challenges and Solutions
**Challenge:** Handling network requests without freezing the user interface or causing application crashes.
**Solution:** The HTTP request logic was moved off the main thread using an asynchronous background task. Once the JSON response is received and parsed, `runOnUiThread` is safely invoked to update the "Tip of the Day" TextView on the screen.

**Challenge:** System notifications were failing to appear on newer Android devices (API 33+).
**Solution:** Modern Android security policies strictly block notifications by default. To resolve this, a runtime permission check was integrated into the `HomeActivity`'s `onCreate` method. The app now explicitly prompts the user to grant the `POST_NOTIFICATIONS` permission upon initial launch, ensuring the notification service functions reliably.

## 5. Conclusion
The "Information for Everyone" application successfully fulfills all requirements for the CMP2004 term project. It demonstrates practical implementation of core Android development concepts, including UI design, Activity lifecycles, background services, and internet connectivity. Beyond technical execution, the project successfully delivers a socially meaningful tool that is polished, accessible, and highly beneficial for disadvantaged individuals.
