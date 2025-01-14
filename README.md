This is the the branch for the admin side of the COMP2000 CW2 Coursework.

This is where I will be implementing functionality across both admin and employee sides of the application, alongside making use of the PostMan API service to provide employee information and SQLLite Browser for the storage of data such as login informtaion and other important data

*Admin Side*
- Add employees to the databse
- View employees from the database
- Update employee details
- Delete employee from the database
- Accept or reject holiday requests
- Automatically increase emplyoee salary by 5% yearly (app does it automatically)

*Employee Side*
- View personal details
- Update personal details (name)
- Request time off (30 days max per year)
- Recieve notifications for updates and holiday approvals or rejections


The GitHub will provide you with my design documents to show the overall evolution of how i went about designing my application using figma. I have listed my inital and final designs in the design documents folder

*Main App Features*
- RESTful API Integration for CRUD operations
- BASE URL FOR API : "http://10.224.41.11/comp2000"
- /employees
get a list of all the employees on the API

- /employees/get/<id>
get details of a specific employee by ID

- /employees/add
Add a new employee to the database

- /employees/edit/<id>
Update the details of an employee currently in the database

- /employees/delete/<id>
Delete an employee from the database

- /health
Checks if the API is operational

