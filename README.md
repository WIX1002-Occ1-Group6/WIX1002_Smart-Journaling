> This is a `zh-cn` translation of document`WIX1002 Assignment Topic 3.pdf`.

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
	[什么是 Git？](https://git-scm.com/book/en/v2/Getting-Started-What-is-Git%3F "什么是 Git？")
	[GitHub 入门](https://docs.github.com/en/get-started "GitHub 入门")
	[在 GitHub 上创建Pull Request](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request "在 GitHub 上创建Pull Request")
	[在 GitHub 上解决合并冲突](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/addressing-merge-conflicts/resolving-a-merge-conflict-on-github "在 GitHub 上解决合并冲突")
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


    .env
    BEARER_TOKEN=hf_xxxxxxxxxxxxxxxxx

截至目前，你的项目文件夹应至少包含以下文件：
`API.java`
`EnvLoader.java`
`.env`
`.gitignore`

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
