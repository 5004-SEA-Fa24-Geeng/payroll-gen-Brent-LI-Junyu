# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for?
   CSV stands for "Comma-Separated Values" - a plain text file format that uses commas to separate values.

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?
   To follow the programming principle of coding to an interface rather than an implementation, providing greater flexibility and easier changes to the code.

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?
   This is called a "has-a" relationship or composition.

4. Can you provide an example of a has-a relationship in your code (if one exists)?
    


5. Can you provide an example of an is-a relationship in your code (if one exists)?
    HourlyEmployee and SalaryEmployee is-a AbstractEmployee
    

6. What is the difference between an interface and an abstract class?
An interface only declares methods without implementation, while an abstract class can have both implemented methods and abstract methods. 
Abstract classes can also have fields. 
A concrete class can have many interfaces, yet only one abstract calss


7. What is the advantage of using an interface over an abstract class?


8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it. 


9. Which class/method is described as the "driver" for your application? 



10. How do you create a temporary folder for JUnit Testing? 


## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 
# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project.

## Technical Questions

1. What does CSV stand for?
   CSV stands for "Comma-Separated Values" - a plain text file format that uses commas to separate values.

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?
   To follow the programming principle of coding to an interface rather than an implementation, providing greater flexibility and easier changes to the code.

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?
   has-a.

4. Can you provide an example of a has-a relationship in your code (if one exists)?
    HourlyEmployee class has-a PayStub.


5. Can you provide an example of an is-a relationship in your code (if one exists)?
   HourlyEmployee and SalaryEmployee is-a AbstractEmployee.


6. What is the difference between an interface and an abstract class?
   An interface only declares methods without implementation, while an abstract class can have both implemented methods and abstract methods.
   Abstract classes can also have fields.
   A concrete class can have many interfaces, yet only one abstract class.


7. What is the advantage of using an interface over an abstract class?
   Interfaces allow multiple inheritance (a class can implement multiple interfaces), while Java only permits single inheritance for classes. Interfaces also provide better decoupling. 
    In short, more flexibility.

8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it.
   Not valid. Because we cannot use primitive types (like int) as type parameters for Java Generics. Fix is to use the wrapper class: List<Integer> numbers = new ArrayList<Integer>();

9. Which class/method is described as the "driver" for your application?
    main method in PayrollGenerator class.

   
10. How do you create a temporary folder for JUnit Testing?
    Use the @TempDir annotation from JUnit 5. It creates a temporary directory that is automatically deleted after the test completes.
    

## Deeper Thinking

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits.

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that.

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity.

According to research from Stanford Graduate School of Business, even when controlling for factors like education and experience, women in STEM fields earn approximately 92 cents for every dollar earned by men (Stanford GSB, 2022). 
Furthermore, a McKinsey study found that companies in the top quartile for gender diversity are 25% more likely to have above-average profitability (McKinsey & Company, 2020).
These data above supports the background statement of the question. 
To address this:
First, I would expand the employee data structure to include additional non-identifying demographic information such as gender, age range, races and education level.
This would allow for statistical analysis of compensation across different demographics while maintaining individual privacy.
Second, I would implement a reporting system that could analyze compensation data across comparable roles, factoring in objective performance metrics.
The system could flag potential inequities when similar employees with comparable performance metrics show significant compensation differences.
The payroll process review should occur both during initial offer generation and during regular compensation reviews. 

References:
1. Stanford Graduate School of Business. (2022). "What's Behind the Pay Gap in STEM Jobs." Retrieved from https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs
2. McKinsey & Company. (2020). "Diversity Wins: How Inclusion Matters." Retrieved from https://www.mckinsey.com/featured-insights/diversity-and-inclusion/diversity-wins-how-inclusion-matters
RetryClaude does not have internet access. Links provided may not be accurate or up to date.