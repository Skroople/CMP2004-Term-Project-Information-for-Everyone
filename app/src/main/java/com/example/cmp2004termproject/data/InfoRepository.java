package com.example.cmp2004termproject.data;

import com.example.cmp2004termproject.model.InfoCategory;
import com.example.cmp2004termproject.model.InfoItem;
import com.example.cmp2004termproject.model.TipItem;

public class InfoRepository {

    private static InfoRepository instance;

    private InfoRepository() {}

    public static synchronized InfoRepository getInstance() {
        if (instance == null) {
            instance = new InfoRepository();
        }
        return instance;
    }

    public InfoCategory[] getAllCategories() {
        return new InfoCategory[] {
            createHealthCategory(),
            createLegalCategory(),
            createSocialCategory()
        };
    }

    public InfoCategory getCategoryById(String categoryId) {
        for (InfoCategory cat : getAllCategories()) {
            if (cat.getId().equals(categoryId)) {
                return cat;
            }
        }
        return null;
    }

    public TipItem[] getAllTips() {
        return new TipItem[] {
            new TipItem(1, "Hydration", "Remember to drink at least 8 glasses of water today! Staying hydrated is essential for your health.", "Health"),
            new TipItem(2, "Medication", "Take your medications on time every day. Set an alarm if needed.", "Health"),
            new TipItem(3, "Exercise", "Walking for 30 minutes can improve your physical and mental health.", "Health"),
            new TipItem(4, "Legal Aid", "You have the right to free legal aid if you cannot afford a lawyer.", "Legal"),
            new TipItem(5, "Work Rights", "Every worker has the right to a safe workplace and fair wages.", "Legal"),
            new TipItem(6, "Housing", "You cannot be evicted without proper legal notice and court approval.", "Legal"),
            new TipItem(7, "Social Support", "Contact your local social services office for assistance with housing, food, and healthcare.", "Social"),
            new TipItem(8, "Community", "Stay connected with family and friends. Social connections are important for your wellbeing.", "Social"),
            new TipItem(9, "Education", "Free adult education programs are available in your community. Contact local NGOs for details.", "Social"),
            new TipItem(10, "Rest", "Get enough sleep - aim for 7-8 hours every night.", "Health"),
            new TipItem(11, "Nutrition", "Eat a balanced diet with fruits and vegetables. Your local food bank can help.", "Health"),
            new TipItem(12, "Health Check", "Regular check-ups with your doctor are important. Don't skip your appointments.", "Health"),
            new TipItem(13, "Mental Health", "It's okay to ask for help. Mental health support is available for free.", "Health"),
            new TipItem(14, "You Are Not Alone", "There are people who care about you. Reach out if you need support.", "Health"),
            new TipItem(15, "Emergency Help", "In case of emergency, dial 112 for immediate assistance.", "Social")
        };
    }

    public TipItem getRandomTip() {
        TipItem[] tips = getAllTips();
        int index = (int) (System.currentTimeMillis() / (24 * 60 * 60 * 1000)) % tips.length;
        return tips[index];
    }

    private InfoCategory createHealthCategory() {
        return new InfoCategory(
            "health",
            "Health Information",
            "Access reliable health tips and medical information",
            new InfoItem[] {
                new InfoItem("h1", "Daily Health Tips",
                    "1. Drink Water: Aim for 8 glasses daily to stay hydrated.\n\n" +
                    "2. Exercise: Even a 30-minute walk can improve your health.\n\n" +
                    "3. Sleep Well: Get 7-8 hours of sleep every night.\n\n" +
                    "4. Eat Vegetables: Include fruits and vegetables in every meal.\n\n" +
                    "5. Regular Check-ups: Visit your doctor for regular health check-ups.",
                    "Daily habits for a healthier life"),
                new InfoItem("h2", "Medication Safety",
                    "Taking medication correctly is important for your health:\n\n" +
                    "- Always take medicine at the same time each day\n\n" +
                    "- Never share your medication with others\n\n" +
                    "- Store medicines in a cool, dry place\n\n" +
                    "- Keep a list of all your medications\n\n" +
                    "- Ask your doctor if you have any questions",
                    "How to manage your medications safely"),
                new InfoItem("h3", "Mental Health Support",
                    "Your mental health is just as important as your physical health:\n\n" +
                    "- It's okay to feel stressed or anxious\n\n" +
                    "- Talk to someone you trust about your feelings\n\n" +
                    "- Contact a mental health helpline for support\n\n" +
                    "- Practice deep breathing and relaxation\n\n" +
                    "- Seek professional help when needed",
                    "Resources and support for mental wellbeing"),
                new InfoItem("h4", "Emergency Health Information",
                    "In case of a medical emergency:\n\n" +
                    "- Call 112 for immediate emergency help\n\n" +
                    "- Keep emergency contacts saved on your phone\n\n" +
                    "- Know the location of your nearest hospital\n\n" +
                    "- Carry your health insurance card always\n\n" +
                    "- Learn basic first aid skills",
                    "What to do in health emergencies"),
                new InfoItem("h5", "Nutrition Basics",
                    "Eating well doesn't have to be complicated:\n\n" +
                    "- Choose whole grains over white bread\n\n" +
                    "- Eat a variety of colorful vegetables\n\n" +
                    "- Limit sugar and salt intake\n\n" +
                    "- Drink water instead of sugary drinks\n\n" +
                    "- Your local food bank can help with healthy food",
                    "Simple guide to eating healthy on any budget")
            }
        );
    }

    private InfoCategory createLegalCategory() {
        return new InfoCategory(
            "legal",
            "Legal Rights",
            "Know your rights and get legal help",
            new InfoItem[] {
                new InfoItem("l1", "Know Your Basic Rights",
                    "Every person has fundamental rights:\n\n" +
                    "- Right to fair treatment\n\n" +
                    "- Right to legal representation\n\n" +
                    "- Right to privacy\n\n" +
                    "- Right to education and healthcare\n\n" +
                    "- Right to be heard in court",
                    "Fundamental rights that apply to everyone"),
                new InfoItem("l2", "Right to Legal Aid",
                    "If you cannot afford a lawyer, you have the right to free legal aid:\n\n" +
                    "- Contact your local bar association\n\n" +
                    "- Legal aid offices provide free lawyers\n\n" +
                    "- Many NGOs offer free legal consultation\n\n" +
                    "- Court-appointed lawyers are available\n\n" +
                    "- Language interpreters are provided if needed",
                    "How to get free legal help"),
                new InfoItem("l3", "Worker Rights",
                    "Every worker deserves fair treatment:\n\n" +
                    "- Minimum wage must be paid\n\n" +
                    "- Safe working conditions are required\n\n" +
                    "- Overtime pay is mandatory\n\n" +
                    "- You cannot be fired without reason\n\n" +
                    "- Report workplace violations to labor offices",
                    "Your rights as a worker"),
                new InfoItem("l4", "Housing Rights",
                    "You have rights as a tenant or homeowner:\n\n" +
                    "- You cannot be evicted without court approval\n\n" +
                    "- Landlords must give proper notice\n\n" +
                    "- Your home must be safe and livable\n\n" +
                    "- You have right to privacy\n\n" +
                    "- Contact housing associations for help",
                    "Protecting your right to housing"),
                new InfoItem("l5", "How to File a Complaint",
                    "If your rights are violated:\n\n" +
                    "1. Document everything with dates and details\n\n" +
                    "2. Contact a lawyer or legal aid office\n\n" +
                    "3. File a complaint with relevant authorities\n\n" +
                    "4. Keep copies of all documents\n\n" +
                    "5. Seek support from NGOs",
                    "Steps to take when your rights are violated")
            }
        );
    }

    private InfoCategory createSocialCategory() {
        return new InfoCategory(
            "social",
            "Social Support Services",
            "Find help with housing, food, and community resources",
            new InfoItem[] {
                new InfoItem("s1", "Emergency Assistance",
                    "If you need immediate help:\n\n" +
                    "- Food banks provide free food parcels\n\n" +
                    "- Shelters offer temporary housing\n\n" +
                    "- Crisis hotlines are available 24/7\n\n" +
                    "- Emergency cash assistance exists\n\n" +
                    "- Call 112 for life-threatening situations",
                    "Resources for urgent needs"),
                new InfoItem("s2", "Housing Assistance",
                    "Help with finding and keeping housing:\n\n" +
                    "- Social housing programs offer affordable rent\n\n" +
                    "- Rental assistance programs help with deposits\n\n" +
                    "- Homeless shelters provide temporary housing\n\n" +
                    "- Contact local municipality for housing help\n\n" +
                    "- NGOs assist with housing applications",
                    "Programs to help you find stable housing"),
                new InfoItem("s3", "Food Assistance",
                    "Access free or affordable food:\n\n" +
                    "- Food banks distribute free food parcels\n\n" +
                    "- Community kitchens serve free meals\n\n" +
                    "- School meal programs help children\n\n" +
                    "- Farmers markets accept food stamps\n\n" +
                    "- Religious organizations provide food aid",
                    "Where to find food help"),
                new InfoItem("s4", "Education Programs",
                    "Opportunities for learning and growth:\n\n" +
                    "- Free adult education classes available\n\n" +
                    "- Literacy programs teach reading and writing\n\n" +
                    "- Language courses help with integration\n\n" +
                    "- Vocational training is often free\n\n" +
                    "- Public libraries offer free resources",
                    "Learning opportunities in your community"),
                new InfoItem("s5", "Community Support",
                    "Connect with your community:\n\n" +
                    "- Community centers offer free activities\n\n" +
                    "- Support groups help with specific challenges\n\n" +
                    "- Volunteer organizations welcome helpers\n\n" +
                    "- Religious communities provide support\n\n" +
                    "- Social workers can connect you to services",
                    "Ways to connect and get support")
            }
        );
    }
}