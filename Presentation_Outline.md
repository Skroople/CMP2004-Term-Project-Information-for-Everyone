# CMP2004 Term Project - Presentation Outline

*This outline is designed for your Week 14 presentation. You can easily copy and paste these points into PowerPoint or Google Slides.*

---

## Slide 1: Title Slide
*   **Project Title:** Information for Everyone (Supportive Information App)
*   **Course:** CMP2004 Advanced Programming
*   **Team Members:** Mehmet Eren Ekşi (2364932) & Yiğit Erel (2483739)

---

## Slide 2: Problem Definition
*   **The Problem:** Navigating essential services (health, legal, social support) is often overly complex, text-heavy, and difficult to understand.
*   **The Barrier:** Information is scattered across the internet, making it hard to find reliable help quickly, especially during emergencies.
*   **The Solution:** A centralized, highly accessible mobile application that curates critical life information into an easy-to-read, navigable format.

---

## Slide 3: Why This User Group is Important
*   **Target Group:** Disadvantaged individuals (those facing technological, cognitive, or socioeconomic barriers).
*   **Why They Matter:** They are often the most in need of critical services (like legal aid or housing) but are the least likely to know how to navigate complex digital systems.
*   **Our Impact:** By providing a straightforward, free, and accessible tool, we empower these individuals to understand their rights, stay healthy, and easily contact emergency help when needed.

---

## Slide 4: Main App Features
*   **Categorized Information:** Cleanly divided into Health, Legal, and Social Support.
*   **Real-Time "Tip of the Day":** Live internet integration fetching daily advice.
*   **Automated Notifications:** Background services reminding users to check their daily tips.
*   **Emergency Access:** One-tap button to call 112 directly from the app.
*   **Accessibility First:** Designed with Android's Light/Dark mode support, large text, and Material Design 3 cards for maximum readability.

---

## Slide 5: Screens and Demo
*(During this slide, show your emulator or device screen. Click through the following flow:)*
1.  **Splash Screen:** Show the opening logo and clean transition.
2.  **Home Screen:** Point out the categories and the dynamic layout animations.
3.  **Category Detail:** Show how the "Tip of the Day" banner loads data from the internet.
4.  **Reading Screen:** Show the scrollable long-form text.
5.  **About/Contact Screen:** Demonstrate clicking the "Call 112" button (it will open the phone dialer) and the "Send Feedback" button (it will open the email app).
6.  **Notification:** Swipe down the status bar to show the system notification!

---

## Slide 6: Technical Explanation
*(Highlight the advanced Android concepts you used to secure full marks:)*
*   **Object-Oriented Programming:** Built on Java MVC architecture with proper data encapsulation (`InfoItem.java`, `InfoRepository.java`).
*   **Networking:** Utilized asynchronous background threads (`HttpRequestTask.java`) to pull JSON data from the Advice Slip API without freezing the UI.
*   **Intents:** Extensive use of Explicit Intents for navigation and Implicit Intents (`ACTION_DIAL`, `ACTION_SENDTO`) for practical features.
*   **Services & Broadcasts:** Combined `TipNotificationService` and `BootReceiver` to push Android system notifications, including modern Android 13+ runtime permission handling.
*   **UI/UX:** Leveraged Material Design 3 principles (`CardView`) and custom XML animations (`res/anim`) for a polished experience.

---

## Slide 7: Conclusion & Q&A
*   **Summary:** "Information for Everyone" successfully meets the technical requirements of the CMP2004 course while delivering a socially meaningful product.
*   **Thank You!**
*   **Questions?**
