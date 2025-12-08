# Smart Journaling

Journaling has long been recognized as a valuable tool for self-expression and personal reflection. It provides individuals with a space to record their thoughts, emotions, and experiences, helping them process their daily lives and reflect on their personal growth.

> “Journaling is a way of capturing your life one day at a time. It is a wonderful way to be able to reflect on your past whether in good times or bad. It is really easy to forget how wonderful your life is in certain times, and a quick look back allows you to see the people, places visited, and get some perspective.”
— George Bonelli

In today’s busy world, many individuals find it difficult to keep track of their daily thoughts, feelings, and experiences. Despite the therapeutic benefits of journaling, people often struggle to maintain a consistent journaling habit or capture the full depth of their emotions. As a result, important memories and reflections can easily be forgotten, leaving individuals disconnected from their past experiences and their emotional journey.
Additionally, mood swings and emotional shifts are often hard to track without a clear record of one’s daily state of mind. Without the ability to reflect on their mood patterns over time, people may miss valuable insights into the causes of their emotional fluctuations. This lack of awareness can prevent individuals from recognizing early signs of stress, anxiety, or other mental health concerns, making it harder to address these issues proactively.

## Project Introduction
The Smart Journaling project aims to tackle the challenges of emotional awareness and personal reflection by leveraging technology to provide a smart, accessible journaling platform. Through features such as mood tracking, AI-driven prompts, and personalized insights, Smart Journaling seeks to help users better understand their emotional patterns, reflect on their experiences, and foster personal growth. By offering an innovative way to engage with one’s emotions and memories, this project aligns with the goals of improving [mental health and well-being (SDG 3).](https://globalgoals.org/goals/3-good-health-and-well-being/ "mental health and well-being (SDG 3).")

Ultimately, the Smart Journaling platform is designed to empower individuals with the tools they need for self-reflection, emotional regulation, and personal development. By promoting regular journaling and emotional awareness, this project strives to create a positive impact on mental health, contributing to a healthier and more informed society.

At the end of this project, you will also learn to:
1.	Call API request in Java
2.	Integrate existing AI models into your project using API 

Since API calls are not the primary focus of this course, the Java methods handling the API requests will be provided for you. Your main task will be to follow the guide in the Appendix and concentrate on extracting relevant values from the API responses.

## What You Will Need To Do
We separated our project functionalities into basic features and extra features. The basic features are the main basic functionalities that our project must have in order to make it workable, the extra features on the other hand will be the additional functionalities which improve the project overall as a whole, which includes scalability and accessibility.

Note that GUI (Graphical User Interface) is considered an extra feature, you may decide to use the CLI (Command-Line Interface) as the interface for the end users to interact with the software.

### Basic Features (8 Marks)

#### User Account & Login / Registration Page [1 mark]

Each user will have their own user account. Therefore, you will need to create a  `User`  class which contains the following required fields:

1.	Email Address
2.	Password
3.	Display Name

We will need a sign-up page for the users to register themselves and a login page for users to log into their accounts from any location. To ease yourself in logic management, the user will log in only by using a valid email, instead of the option to log in with a username.

Here, I have created 2 mock user accounts for you to test your program out, you can create more accounts if you want but these 2 accounts have to be in your project for this section’s presentation.

    UserData.txt

    s100201@student.fop
	Foo Bar
	pw-Stud#1
	s100202@student.fop
	John Doe
	pw-Stud#2

The list above is in the format of EmailAddress, DisplayName, Password, separated by a “New Line” or  `\n` . Copy and paste the list above in  `UserData.txt`  file, meaning that the content of that file should look EXACTLY as the content shown above.

#### Data Storage [1 mark]

Throughout the project, we expect various data generated like user details, user’s current state and many more. So, we will need to store all related data in data storage so that the data remains saved even after the program is terminated. For basic features, you may save each user’s data in CSV, TXT or BAT format.

Note that using external data storage or databases (refer to Extra Features) are counted as extra features. However, you are still required to have AT LEAST ONE file I/O application in order to get this mark. 

#### Welcome Page & Menu [1 mark]

After logging in, the user will be greeted with a welcome message on the landing page. The welcome message should start with the following greeting based on the current time, followed by the user’s display name. To keep things simple, here are the rules:

| Time of the day (GMT+8)  | Greetings   |
| ------------ | ------------ |
| 00:00 - 11:59   | Good Morning  |
| 12:00 - 16:59  | Good Afternoon   |
| 17:00 - 23:59   | Good Evening   |

This smart journal project only needs 2 main functionalities:

1.	Create, Edit & View Journals
2.	View Weekly Mood Summary

#### Journal Page [2 marks]

Upon selecting the option to create & view journals, users will see a list of past journal dates, extending up to the current day.

###### Example: Journals Page

    === Journal Dates ===
    1.	2025-10-08
    2.	2025-10-09
    3.	2025-10-10
    4.	2025-10-11 (Today)

    Select a date to view journal, or create a new journal for today:
	> 1

For any past date displayed, users have the option to view the journal entry written on that specific day.

For the current date, the following options are available:
1.	If no journal entry has been recorded for the current date, the user will be prompted to "Create Journal."
2.	Once a journal entry has been created, the user can then choose to "View Journal" or "Edit Journal."

###### Example: View a Journal Entry

    === Journal Entry for 2025-10-10 ===
    I had a great day at the park with my friends.

    Press Enter to go back.
    >

When a new journal entry is initiated, a message will appear, prompting the user to begin typing their journal. An example of this process is shown below.

###### Example: Create a New Journal Entry

    Select a date to view journal, or create a new journal for today: 
    > 4

    Enter your journal entry for 2025-10-11: 
	> Today I learned how to create a simple journal app!

    Journal saved successfully!

    Would you like to:
    1.	View Journal
    2.	Edit Journal
    3.	Back to Dates

    > 3

###### Example: Edit Today’s Journal Entry

    Select a date to view journal, or edit the journal for today:
    > 4

    Edit your journal entry for 2025-10-11:
    > Today I learned how to create a simple terminal journal app!

Note that when no journal entry exists for the current day, the instructions should prompt the user to `“create a new journal for today.”` Once a journal entry has been created, the prompt should change to offer the option to `“edit the journal for today.”`

You may rephrase these instructions as you see fit, but the logic must be clear to prevent users from becoming confused about why they can create a new journal if one already exists for the current day.

#### Weather Recording [1 mark]

Traditional diaries require users to manually note down the weather for the day (given that the user wants to track the weather). In this project, we would automatically retrieve the weather data based on the user's current location.

In order to do so, we will need to use an API to retrieve the current weather data. To understand more about API, you may refer to [this article](https://www.google.com/search?q=what+is+api "this article") or explore online. But for this project, the API can be considered like a Java method that returns a result based on input parameters.

To ease the process, we will use the following API from [Malaysia’s official open data portal](https://developer.data.gov.my/ "Malaysia’s official open data portal"), which uses the first type of API calling — [GET](https://www.w3schools.com/tags/ref_httpmethods.asp "GET"). I have also created a Java class that does the API calling, in which the code can be found in the Appendix.

###### Sample Weather API Response (Formatted)

```json
[
    {
        "location": {
            "location_id": "St009",
            "location_name": "WP Kuala Lumpur"
        },
        "date": "2025-10-11",
        "morning_forecast": "Ribut petir di beberapa tempat",
        "afternoon_forecast": "Ribut petir di beberapa tempat",
        "night_forecast": "Tiada hujan",
        "summary_forecast": "Ribut petir di beberapa tempat",
        "summary_when": "Pagi dan Petang",
        "min_temp": 23,
        "max_temp": 34
    }
]
```

This API returns the weather data and weather forecast of the current date, and for additional simplicity, we will only extract the value of the `summary_forecast` field for the current date. So if the current date is 11 October 2025, the weather would be `"Ribut petir di beberapa tempat"`. Finally, link the weather to the journal entry for that day.

This part focuses more on testing your knowledge on integrating methods from other Java classes and also value extraction from String objects. You may also play with different API to obtain the weather data.

#### Sentiment Analysis [1 mark]

Sometimes writing down your mood is difficult as it is too abstract to describe your mood, thus this project uses sentiment analysis model to classify your mood sentiment based on the input journal sentence.

Similarly, we will be using API calling from Hugging Face’s model. By leveraging existing open sourced models, we are able to incorporate AI functionalities into our system and make our project “smarter”. Here we will use [DistilBERT base uncased finetuned SST-2](https://huggingface.co/distilbert/distilbert-base-uncased-finetuned-sst-2-english "DistilBERT base uncased finetuned SST-2") model to provide sentiment classification on the journal sentence.

This part will introduce you to the second kind of API call — [POST](https://www.w3schools.com/tags/ref_httpmethods.asp "POST"). Read more on the implementation and code examples in the Appendix.

###### Sample Model API Response (Formatted)

```json
[
    [
        {
            "label":"POSITIVE",
            "score":0.9998701810836792
        },
        {
            "label":"NEGATIVE",
            "score":0.00012976663128938526
        }
    ]
]
```

From the sample API response, we see that the response includes 2 labels each with a score. The score can be considered as the likelihood of the label being true for the input journal sentence, thus we will only use the label with the higher score. Link the label as mood to the journal entry for that day.

You may also experiment with different available models in Hugging Face or even try an entirely different model API.

*p.s. I realized that the label that has the highest score will display first, this finding could perhaps help you out in value extraction.*

#### Weekly Summary Page [1 mark]

Lastly, the weekly summary page provides an overview of the weather and mood from the past seven days, allowing users to review the weather changes over the week and also their mood fluctuations throughout the week.

### Suggested Extra Features (4 Marks)

Marks at this section are given based on the amount of impact or significance that the suggested features or extra features by students has towards the project as a whole. It is SUBJECTED to the demonstrator or the lecturer giving the marks to decide how much marks should be awarded for each extra feature.

#### Graphical User Interface (1 - 3  Marks)

A graphical user interface (GUI) is a digital interface in which a user interacts with graphical components such as icons, buttons, and menus. In a GUI, the visuals displayed in the user interface convey information relevant to the user, as well as actions that they can take. A nice-looking and user-friendly GUI will give the user a better experience using the software. You may choose to use [JavaFX](https://openjfx.io/ "JavaFX") or [Spring Boot](https://spring.io/projects/spring-boot "Spring Boot") with other technologies to do so.

#### Relational Database (1 - 2 Marks)

A relational database is a collection of information that organizes data in predefined relationships where data is stored in one or more tables (or "relations") of columns and rows, making it easy to see and understand how different data structures relate to each other. Relationships are a logical connection between different tables, established on the basis of interaction among these tables. You may use [Oracle Database](https://www.oracle.com/my/database/ "Oracle Database"), [MySQL](https://www.mysql.com/ "MySQL"), [PostgreSQL](https://www.postgresql.org/ "PostgreSQL"), [Firestore](https://firebase.google.com/docs/firestore "Firestore") or other relational databases to do so.

Note that the parts where you are required to copy and paste the content in this assignment question into a text file like the `UserData.txt`, you may load them into your database instead of writing it in a `.txt` file. Just to remind that you are still required to have **AT LEAST ONE** file I/O application in order to get the mark for Data Storage at Basic Feature.

#### Password Hashing (1 Mark)

Storing the raw passwords of our users in any kind of storage violates the basic privacy of the users. According to the [United Kingdom’s Article 5 of Regulation (EU) 2016/679](https://www.legislation.gov.uk/eur/2016/679/article/5 "United Kingdom’s Article 5 of Regulation (EU) 2016/679") of the European Parliament and of the Council, personal data shall be processed in a manner that ensures appropriate security of the personal data, including protection against unauthorised or unlawful processing and against accidental loss, destruction or damage, using appropriate technical or organisational measures (‘integrity and confidentiality’). You may use hashing, Caesar cipher, or any other encryption algorithm to tackle this matter. However, you must be able to justify the algorithm during the presentation. Plus, you should also show that your database or the text file’s password section stores the hashed version of the password.

#### Expanding Functionalities on Existing Features (1 - 3 Marks)

Since this project is super basic compared to existing systems like Day One or Reflection, you are highly encouraged to add some functionalities to each page or existing features. One simple example is to create a mapping rule (if-else) to map [different possible values](https://developer.data.gov.my/realtime-api/weather#possible-values-for-_forecast-fields "different possible values") of the `weather_forecast` field to simpler English terms like “sunny”, “rainy” etc.

Note that the impact of your added functionalities affect the marks awarded as extra features, i.e. more impactful or significant functionality rather than a small add-on grants you more marks.

## Tips For This Assignment

To help you complete the assignment easily, here are some tips from our experiences in doing project-based assignments.

### Modularity

This project is modular and can be separated into a few parts:

1.	Login / User Registration, User Class creation and Data Storage
2.	Welcome Page and Summary Page
3.	Journal Page
4.	Weather Value Extraction
5.	Mood Classification Value Extraction

This eases your team to delegate the tasks among the team members to effectively construct each functionality separately and compile together after testing has been done. Note that the separation above is just a suggestion and not compulsory to follow while your team distributes tasks and responsibilities.

### Version Control

We encourage you to utilize Git versioning and the GitHub platform while collaborating with your team to complete this project. It also serves the purpose of tracking the contribution of each team member in this project and avoiding “free-riders”.

You may read more about Git and GitHub in the following links:

- [What is Git?](https://git-scm.com/book/en/v2/Getting-Started-What-is-Git%3F "What is Git?")
- [Getting Started on GitHub](https://docs.github.com/en/get-started "Getting Started on GitHub")
- [Creating Pull Requests on GitHub](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request "Creating Pull Requests on GitHub")
- [Resolving Merge Conflicts on GitHub](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/addressing-merge-conflicts/resolving-a-merge-conflict-on-github "Resolving Merge Conflicts on GitHub")

### Relative Path

Since there are many File I/O involved in this assignment, there is a tendency that developers use their local absolute file path in their code. Here’s a sample difference between absolute path and relative path:

	Absolute Path: `C:\Users\Documents\WIX1002\Assignment\SampleInput.txt`

	Relative Path:
    `./SampleInput.txt` (given that the project root ~ is at the \Assignment\ folder as shown in the Absolute Path)

We strongly advise you to NOT use the absolute path but use the relative path since the file path in your PC will NOT necessarily be the same for your other project collaborators, but the file hierarchy in the project should be the same for all of your project collaborators.
 
## Contact Me

If you have any questions or need clarifications about the assignment, please contact me, Lim Jun Yi, using either of the following methods:

1.	WhatsApp me at `+60123681620`
2.	Email me at `22004811@siswa.um.edu.my`

I will try my best to answer your questions as soon as possible. Hope you enjoy this assignment!

## Appendix
I have created the necessary files required for API calling in [this GitHub repository](https://github.com/LimJY03/SmartJournal "this GitHub repository"). Inside the repository you should see 2 Java Files and 1 `.gitignore` file:

1.	`API.java`: Main class containing API calling functions and sample usage
2.	`EnvLoader.java`: Custom class to read sensitive information from `.env` file
3.	`.gitignore`: To prevent sensitive information in `.env` from being exposed

Make sure you copy these 3 files in your project folder.

## Getting Access Token for Hugging Face Model API Calling

**IMPORTANT DISCLAIMER:**

**Your Hugging Face access token is private and sensitive information. Do NOT share or expose your token publicly or with others. Each user should use their own token stored securely in a `.env` file. Make sure your `.env` file is included in `.gitignore` to prevent accidental sharing of this sensitive information, especially when using version control like Git. This helps keep your account and data secure.**

For hugging face model API calling, we will need to first get an access token from the [Hugging Face Website](https://huggingface.co/join "Hugging Face Website"). The steps are listed as follows:

1.	Create a new account (unless you already have one) at HuggingFace.
2.	After logging in, find “Settings” in the side bar or click your profile icon at the top right of the menu bar > “Settings”.
3.	Click “Access Tokens” > “Create New Token”
4.	Select “Fine-grained”, give this token any name, and check all boxes in the Inference section.
5.	Scroll to the bottom and click “Create token”.
6.	A pop-up dialog titled “Save your Access Token” will show up, copy your token (`hf_xxxXXXXXXXXXXXXXx`).
7.	In your project repository, create a file called `.env` and paste your access token similar to below in the file:

    BEARER_TOKEN=hf_xxxxxxxxxxxxxxxxx

As of now, your project folder should at least have these files:

- `API.java`
- `EnvLoader.java`
- `.env`
- `.gitignore`

### How to Use API Calling
In `API.java`, look for the comment `// Example Usage`. It contains the sample usage of API calling for GET weather data and POST to obtain mood prediction.

For GET weather data, you will use the same API URL (getURL) as given in the code, and use `api.get()` method to obtain the response string as shown in “Sample Weather API Response (Formatted)”. Then, use your knowledge in value extraction to extract the value needed.

For POST to obtain mood prediction, you will also use the same API URL (postURL) as given in the code, ensure that you have the access token in your `.env` file, and initialize the journalInput variable with the user’s journal input sentence (e.g. `"Today I learned how to create a simple terminal journal app!"`). This sentence is being used in the `journalInput` 变量。这个句子被用在 `jsonBody` variable which would be “posted” to the model API as model input, and the model API will return the predicted score as shown in “Sample Model API Response (Formatted)” via the `api.post()` method. Then, use your knowledge in value extraction to extract the value needed.

**Note:** If you want to experiment with different models instead of the one provided (`distilbert/distilbert-base-uncased-finetuned-sst-2-english`), you may change it to your preferred model as follows:

To use `tabularisai/multilingual-sentiment-analysis` model, the API URL would be https://router.huggingface.co/hf-inference/models/tabularisai/multilingual-sentiment-analysis

However, please check if the model supports this way of API calling (with URL):

1.	In the model page, click “Deploy” and see if there is an option called “Inference Providers”.
2.	If there is, the model supports this way of API calling.
3.	If there isn’t, try looking for other models.

------------

> The following section is a `zh-cn` translation of the document.

# 智能日记 - Smart Journaling

长期以来，写日记一直被认为是自我表达和个人反思的宝贵工具。它为个人提供了一个记录想法、情绪和经历的空间，帮助他们处理日常生活并反思个人成长。

> “写日记是一种一次一天捕捉生活的方式。无论顺境还是逆境，这都是一种反思过去的美妙方式。在某些时候，人们很容易忘记生活是多么美好，而短暂的回顾可以让你看到遇到的人、去过的地方，并获得一些感悟。”
—— 乔治·博内利 (George Bonelli)

在当今忙碌的世界中，许多人发现很难跟踪自己日常的想法、感受和经历。尽管写日记有益于身心，但人们常常难以保持一致的日记习惯或捕捉到完整的情感深度。结果，重要的记忆和反思很容易被遗忘，导致个人与过去的经历和情感旅程脱节。

此外，如果没有清晰的日常精神状态记录，情绪波动和情感变化通常很难跟踪。如果无法反思自己随时间变化的情绪模式，人们可能会错失对其情绪波动原因的宝贵见解。这种意识的缺乏可能会阻碍个人识别压力、焦虑或其他心理健康问题的早期迹象，从而更难主动解决这些问题。

## 项目介绍

智能日记项目旨在通过利用技术提供一个智能、易于访问的日记平台，来应对情感意识和个人反思方面的挑战。通过情绪跟踪、人工智能驱动的提示和个性化见解等功能，智能日记力求帮助用户更好地了解自己的情绪模式，反思自身经历，并促进个人成长。通过提供一种与个人情绪和记忆互动的创新方式，该项目符合改善心理健康和福祉的目标（可持续发展目标 3）。

最终，智能日记平台旨在赋予个人自我反思、情绪调节和个人发展所需的工具。通过倡导定期写日记和提高情绪意识，该项目努力对心理健康产生积极影响，为一个更健康、更知情的社会做出贡献。

在本项目结束时，你还将学会：

1.	在 Java 中调用 API 请求
2.	使用 API 将现有的人工智能模型集成到你的项目中
由于 API 调用不是本课程的主要重点，处理 API 请求的 Java 方法将提供给你。你的主要任务是遵循附录中的指南，并专注于从 API 响应中提取相关值。

## 你需要做什么

我们将项目功能分为基本功能和额外功能。基本功能是使我们的项目可行的主要基础功能，而额外功能则是改进项目整体的附加功能，包括可扩展性和可访问性。
请注意，GUI（图形用户界面）被视为一项额外功能，你可以决定使用 CLI（命令行界面）作为最终用户与软件交互的界面。

### 基本功能 (8 分)

#### 用户帐户和登录/注册页面 [1 分]

每个用户都将拥有自己的用户帐户。因此，你需要创建一个 `User` 类，其中包含以下必填字段：

1.	电子邮件地址
2.	密码
3.	显示名称

我们将需要一个注册页面供用户注册，以及一个登录页面供用户从任何位置登录其帐户。为了简化逻辑管理，用户将仅使用有效的电子邮件地址登录，而不是使用用户名登录的选项。

在这里，我创建了 2 个模拟用户帐户供你测试程序，你可以根据需要创建更多帐户，但这两个帐户必须在你的项目中，用于此部分的演示。

    UserData.txt

    s100201@student.fop
	Foo Bar
	pw-Stud#1
	s100202@student.fop
	John Doe
	pw-Stud#2

以上列表的格式为：电邮地址、显示名称、密码，以换行或 `\n` 分隔。复制并粘贴以上列表到 `UserData.txt` 文件中，这意味着该文件的内容应与上面显示的内容完全一致。

#### 数据存储 [1 分]

在整个项目中，我们期望生成各种数据，如用户详细信息、用户当前状态等等。因此，我们将需要将所有相关数据存储在数据存储中，以便即使在程序终止后数据也能保持保存状态。对于基本功能，你可以将每个用户的数据保存为 CSV、TXT 或 BAT 格式。

请注意，使用外部数据存储或数据库（请参阅额外功能）被视为额外功能。但是，你仍然需要至少一个文件 I/O 应用程序才能获得此分数。

#### 欢迎页面和菜单 [1 分]

登录后，用户将在着陆页上看到一条欢迎消息。欢迎消息应根据当前时间以下列问候语开头，后跟用户的显示名称。为简单起见，规则如下：

| Time of the day (GMT+8)  | Greetings   |
| ------------ | ------------ |
| 00:00 - 11:59   | Good Morning  |
| 12:00 - 16:59  | Good Afternoon   |
| 17:00 - 23:59   | Good Evening   |

这个智能日记项目只需要 2 个主要功能：

1.	创建、编辑和查看日记
2.	查看每周情绪总结

#### 日记页面 [2 分]

当选择创建和查看日记的选项时，用户将看到一个过去日记日期的列表，该列表会扩展到当天

###### 示例：日记页面

    === Journal Dates ===
    1.	2025-10-08
    2.	2025-10-09
    3.	2025-10-10
    4.	2025-10-11 (Today)

    Select a date to view journal, or create a new journal for today:
	> 1

对于显示的任何过去日期，用户可以选择查看在该特定日期编写的日记条目。

对于当前日期，提供以下选项：

1.	如果当前日期尚未记录日记条目，系统将提示用户“创建日记”。
2.	一旦创建了日记条目，用户便可以选择“查看日记”或“编辑日记”。

###### 示例：查看日记条目

    === Journal Entry for 2025-10-10 ===
    I had a great day at the park with my friends.

    Press Enter to go back.
    >

当启动新的日记条目时，将出现一条消息，提示用户开始输入他们的日记。此过程示例如下所示。

###### 示例：创建新日记条目

    Select a date to view journal, or create a new journal for today: 
    > 4

    Enter your journal entry for 2025-10-11: 
	> Today I learned how to create a simple journal app!

    Journal saved successfully!

    Would you like to:
    1.	View Journal
    2.	Edit Journal
    3.	Back to Dates

    > 3

###### 示例：编辑今天的日记条目

    Select a date to view journal, or edit the journal for today:
    > 4

    Edit your journal entry for 2025-10-11:
    > Today I learned how to create a simple terminal journal app!

请注意，当当天没有日记条目时，说明应提示用户`“create a new journal for today.”`。一旦创建了日记条目，提示应更改为提供`“edit the journal for today.”`的选项。

你可以根据需要重新措辞这些说明，但逻辑必须清晰，以防止用户对为什么在当天已存在日记的情况下仍能创建新日记感到困惑。

#### 天气记录 [1 分]

传统的日记需要用户手动记下当天的天气（如果用户想要跟踪天气的话）。在这个项目中，我们将根据用户的当前位置自动检索天气数据。

为此，我们将需要使用一个 API 来检索当前的天气数据。要了解有关 API 的更多信息，你可以参阅[这篇文章](https://www.google.com/search?q=what+is+api "这篇文章")或在线探索。但对于这个项目，API 可以被视为一个根据输入参数返回结果的 Java 方法。

为了简化流程，我们将使用来自[马来西亚官方开放数据门户](https://developer.data.gov.my/ "马来西亚官方开放数据门户")的以下 API，它使用第一种 API 调用类型 - [GET](https://www.w3schools.com/tags/ref_httpmethods.asp "GET"). 我还创建了一个执行 API 调用的 Java 类，其代码可以在附录中找到。

###### 示例天气 API 响应（已格式化）

```json
[
    {
        "location": {
            "location_id": "St009",
            "location_name": "WP Kuala Lumpur"
        },
        "date": "2025-10-11",
        "morning_forecast": "Ribut petir di beberapa tempat",
        "afternoon_forecast": "Ribut petir di beberapa tempat",
        "night_forecast": "Tiada hujan",
        "summary_forecast": "Ribut petir di beberapa tempat",
        "summary_when": "Pagi dan Petang",
        "min_temp": 23,
        "max_temp": 34
    }
]
```

此 API 返回当前日期的天气数据和天气预报，为进一步简化，我们将仅提取当前日期 `summary_forecast` 字段的值。因此，如果当前日期是 2025 年 10 月 11 日，天气将是 `"Ribut petir di beberapa tempat"`。最后，将该天气链接到当天的日记条目。

这部分更侧重于测试你关于集成其他 Java 类中的方法以及从字符串对象中提取值的知识。你也可以尝试使用不同的 API 来获取天气数据。

#### 情绪分析 [1 分]

有时候，写下你的情绪很困难，因为它太抽象而难以描述。因此，本项目使用情绪分析模型，根据输入的日记句子来分类你的情绪。

同样，我们将使用来自 Hugging Face 模型的 API 调用。通过利用现有的开源模型，我们能够将人工智能功能整合到我们的系统中，使我们的项目“更智能”。这里我们将使用 [DistilBERT base uncased finetuned SST-2](https://huggingface.co/distilbert/distilbert-base-uncased-finetuned-sst-2-english "DistilBERT base uncased finetuned SST-2") 模型来对日记句子进行情绪分类。

这部分将向你介绍第二种 API 调用 - [POST](https://www.w3schools.com/tags/ref_httpmethods.asp "POST")。在附录中阅读有关实现和代码示例的更多信息。

###### 示例模型 API 响应（已格式化）

```json
[
    [
        {
            "label":"POSITIVE",
            "score":0.9998701810836792
        },
        {
            "label":"NEGATIVE",
            "score":0.00012976663128938526
        }
    ]
]
```

从示例 API 响应中，观察到响应包含 2 个标签，每个标签都有一个分数。该分数可以被视为标签对于输入日记句子为真的可能性，因此我们将只使用得分较高的标签。将该标签作为情绪链接到当天的日记条目。

你也可以在 Hugging Face 中试验不同的可用模型，甚至尝试一个完全不同的模型 API。

*附：通过观察发现得分最高的标签会首先显示，这个发现或许能帮助你提取值。*

#### 每周总结页面 [1 分]

最后，每周总结页面提供了过去七天天气和情绪的概览，允许用户回顾一周内的天气变化以及他们一周内的情绪波动。

### 建议的额外功能 (4 分)

此部分的分数是根据建议的功能或学生提出的额外功能对项目整体产生的影响或重要性来给予的。每项额外功能应授予多少分数，由演示者或评分的讲师决定。

#### 图形用户界面 (1-3 分)

图形用户界面 (GUI) 是一种数字界面，用户通过它与图形组件（如图标、按钮和菜单）进行交互。在 GUI 中，用户界面中显示的视觉效果传达了与用户相关的信息，以及他们可以执行的操作。一个美观且用户友好的 GUI 将为用户提供更好的软件使用体验。你可以选择使用 [JavaFX](https://openjfx.io/ "JavaFX") 或 [Spring Boot](https://spring.io/projects/spring-boot "Spring Boot") 结合其他技术来实现。

#### 关系数据库 (1-2 分)

关系数据库是组织数据于预定义关系中的信息集合，其中数据存储在一个或多个表（或“关系”）的列和行中，使其易于查看和理解不同数据结构之间的相互关系。关系是不同表之间的逻辑连接，建立在这些表之间交互的基础上。你可以使用 [Oracle Database](https://www.oracle.com/my/database/ "Oracle Database"), [MySQL](https://www.mysql.com/ "MySQL"), [PostgreSQL](https://www.postgresql.org/ "PostgreSQL"), [Firestore](https://firebase.google.com/docs/firestore "Firestore") 或其他关系数据库来实现。

请注意，本作业问题中要求你将内容复制并粘贴到文本文件（如 `UserData.txt`）的部分，你可以将它们加载到数据库中，而不是写入 `.txt` 文件。只是提醒你，你仍然需要**至少一个**文件 I/O 应用程序，才能获得基本功能中数据存储的分数。

#### 密码哈希 (1 分)

以任何形式存储用户的原始密码都侵犯了用户的基本隐私。根据[英国《欧洲议会和理事会条例 (EU) 2016/679》第 5 条](https://www.legislation.gov.uk/eur/2016/679/article/5 "英国《欧洲议会和理事会条例 (EU) 2016/679》第 5 条")，个人数据的处理方式应确保个人数据的适当安全，包括使用适当的技术或组织措施，防止未经授权或非法的处理以及意外丢失、破坏或损坏（“完整性和机密性”）。你可以使用哈希、凯撒密码或任何其他加密算法来解决此问题。但是，你必须能够在演示期间证明该算法的合理性。此外，你还应该展示你的数据库或文本文件的密码部分存储的是密码的哈希版本。

#### 扩展现有功能 (1-3 分)

由于与 Day One 或 Reflection 等现有系统相比，这个项目非常基础，因此强烈鼓励你为每个页面或现有功能添加一些功能。一个简单的例子是创建一个映射规则（if-else）来将`weather_forecast`字段的[各种可能值](https://developer.data.gov.my/realtime-api/weather#possible-values-for-_forecast-fields "各种可能值")映射为更简单的英语术语，如 "sunny"（晴天）、"rainy"（雨天）等。

请注意，你添加功能的影响会影响作为额外功能授予的分数，即更有影响力或更重要的功能（而不是小的附加功能）会为你赢得更多分数。

## 完成此作业的提示

为了帮助你轻松完成作业，这里有一些我们根据项目制作业经验总结的提示。

### 模块化

这个项目是模块化的，可以分为几个部分：

1.	登录/用户注册、用户类创建和数据存储
2.	欢迎页面和总结页面
3.	日记页面
4.	天气值提取
5.	情绪分类值提取

这有助于你的团队在团队成员之间分配任务，以有效地分别构建每个功能，并在测试完成后编译在一起。请注意，以上划分只是一个建议，并非强制要求你的团队在分配任务和职责时遵循。

### 版本控制

我们鼓励你在与团队协作完成此项目时利用 Git 版本控制和 GitHub 平台。这也有助于跟踪每个团队成员在此项目中的贡献，并避免“搭便车者”。

你可以在以下链接中阅读有关 Git 和 GitHub 的更多信息：

- [什么是 Git？](https://git-scm.com/book/en/v2/Getting-Started-What-is-Git%3F "什么是 Git？")
- [GitHub 入门](https://docs.github.com/en/get-started "GitHub 入门")
- [在 GitHub 上创建Pull Request](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request "在 GitHub 上创建Pull Request")
- [在 GitHub 上解决合并冲突](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/addressing-merge-conflicts/resolving-a-merge-conflict-on-github "在 GitHub 上解决合并冲突")

### 相对路径

由于此作业涉及许多文件 I/O 操作，开发人员倾向于在代码中使用其本地绝对文件路径。以下是绝对路径和相对路径之间的示例差异：

	绝对路径： `C:\Users\Documents\WIX1002\Assignment\SampleInput.txt`
	相对路径： `./SampleInput.txt` （假设项目根目录 ~ 位于绝对路径中所示的 \Assignment\ 文件夹）

我们强烈建议你不要使用绝对路径，而是使用相对路径，因为你电脑中的文件路径不一定与你其他项目协作者的相同，但项目中的文件层次结构对于所有项目协作者来说应该是一致的。
 
## 联系指导

如果你对作业有任何疑问或需要澄清，请通过以下任一方式联系我，Lim Jun Yi：

1.	WhatsApp 我：`+60123681620`
2.	给我发电子邮件：`22004811@siswa.um.edu.my`

我会尽我所能尽快回答你的问题。希望你喜欢这个作业！

## 附录

我已经在[这个 GitHub 仓库](https://github.com/LimJY03/SmartJournal "这个 GitHub 仓库")中创建了 API 调用所需的必要文件。 在该仓库中，你应该会看到 2 个 Java 文件和 1 个 `.gitignore` 文件：

1.	`API.java`: 包含 API 调用函数和示例用法的主类
2.	`EnvLoader.java`: 用于从 `.env` 文件读取敏感信息的自定义类
3.	`.gitignore`: 防止 `.env` 中的敏感信息被泄露

确保将这 3 个文件复制到你的项目文件夹中。

## 获取用于 Hugging Face 模型 API 调用的访问令牌

**重要免责声明：
你的 Hugging Face 访问令牌是私密且敏感的信息。切勿公开分享或向他人泄露你的令牌。每个用户都应使用自己安全存储在 `.env` 文件中的令牌。确保你的 `.env` 文件包含在 `.gitignore` 中，以防止意外共享此敏感信息，尤其是在使用 Git 等版本控制时。这有助于确保你的帐户和数据安全。**

对于 Hugging Face 模型 API 调用，我们首先需要从[Hugging Face 网站](https://huggingface.co/join "Hugging Face 网站")获取一个访问令牌。步骤如下：

1.	在 HuggingFace 网站创建一个新帐户（除非你已有帐户）。
2.	登录后，在侧边栏中找到“Settings”，或者点击菜单栏右上角的个人资料图标 > “Settings”。
3.	点击“Access Tokens” > “Create New Token
4.	选择“Fine-grained”，给这个令牌起一个任意的名字，并勾选 Inference（推理）部分的所有复选框。
5.	滚动到底部，点击“Create token”。
6.	将弹出一个标题为“Save your Access Token”的对话框，复制你的令牌（`hf_xxxXXXXXXXXXXXXXx`）。
7.	在你的项目仓库中，创建一个名为 `.env` 的文件，并将你的访问令牌粘贴到文件中，类似于以下内容：

    BEARER_TOKEN=hf_xxxxxxxxxxxxxxxxx

截至目前，你的项目文件夹应至少包含以下文件：

- `API.java`
- `EnvLoader.java`
- `.env`
- `.gitignore`

### 如何使用 API 调用

在 `API.java` 中，查找注释 `// Example Usage`。它包含了用于 GET 天气数据和 POST 获取情绪预测的 API 调用的示例用法。
对于 GET 天气数据，你将使用代码中给出的相同 API URL (getURL)，并使用 `api.get()` 方法获取响应字符串，如“示例天气 API 响应（已格式化）”中所示。然后，使用你的值提取知识来提取所需的值。

对于 POST 获取情绪预测，你也将使用代码中给出的相同 API URL (postURL)，确保你的 `.env` 文件中有访问令牌，并使用用户的日记输入句子（例如 `"Today I learned how to create a simple terminal journal app!"`）初始化 `journalInput` 变量。这个句子被用在 `jsonBody` 变量中，它将被“POST”到模型 API 作为模型输入，模型 API 将通过 `api.post()` 方法返回预测分数，如“示例模型 API 响应（已格式化）”中所示。然后，使用你的值提取相关知识，来提取所需的值。

**注意：** 如果你想试验不同的模型，而不是提供的模型（`distilbert/distilbert-base-uncased-finetuned-sst-2-english`），你可以按如下方式将其更改为你偏好的模型：
要使用 `tabularisai/multilingual-sentiment-analysis` 模型，API URL 将是https://router.huggingface.co/hf-inference/models/tabularisai/multilingual-sentiment-analysis

但是，请检查该模型是否支持这种 API 调用方式（使用 URL）：

1.	在模型页面中，点击“Deploy”并查看是否有一个名为“Inference Providers”的选项。
2.	如果有，则该模型支持这种 API 调用方式。
3.	如果没有，请尝试寻找其他模型。
