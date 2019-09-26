描述：本工程代码为实现数据驱动的移动自动化框架项目

结构说明：
base
里面有个BasePrepare.java,这个类的主要作用是启动和关闭APP的作用，启动APP使用了TetsNG的@BeforeClass ，在@BeforeClass下会初始化APP并设置与APPIUM通信的相关数据。
关闭APP使用了TestNG的@AfterClass，在这个注解下写了APP退出的操作；
测试用例类中则是以@Test注释为主体的，在@Test注释下，书写了完整的测试步骤。测试用例继承这个BasePrepare.java，这样在运行测试类的时候，它先会去BasePrepare.java中找@BeforeClass下的代码去执行，然后再去执行@Test的内容，最后在执行@AfterClass的内容。

pages
页面元素类，每一个java类，都是一个页面，存放的都是对应页面的所有元素。

pageshelper
存放的是对应页面的帮助类，这是什么意思？简单的说：在这个页面上做了什么操作都写在这个pageshelper中，比如我登录页面的方法，都写在登录帮助类中。
plugins
主要存放的是html报告插件和excel报告插件。
testcases
顾名思义就是存放测试用例的地方，在这个包下，还会有很多子包，子包的个数根据你测试的系统的模块来划分，比如你有登录模块，首页模块等，那么我们起子包的名字就应该写成login、home。
utils
封装了各种工具类，包括读取excel，appium api封装类，读取数据库类，读取属性文件类和生成driver的类等。
test
test包下是单元测试中用到的测试类,非实际业务代码

代码目录以及介绍完毕，下面介绍下剩下的文件夹都是干什么的。
bin目录：项目编译生成class文件存放目录，这个目录不用去管，Eclipse会自动控制。
config目录：存储框架类所需的所有属性文件，比如arrow的配置文件以及自定义的一些属性文件。
data目录：各模块需要用到一些测试数据，以Excel文件形式存放该目录下。每个模块对应一个Excel文件，每个sheet对应的是一个测试用例的测试用例。
res目录：主要存放的是测试app，当然也会存放一些图片，第三方脚本（主要是为了辅助测试）等。
result目录：存储测试框架运行测试用例生成的报告（包含log，截图等）
src和target目录：可以不用管，由maven控制即可，整个框架，没有用到此目录，大家可以忽略。
接下来还剩几个xml文件，我们也来一一介绍一下：
pom.xml：maven的配置文件，项目核心配置，用于构建项目、自动下载项目依赖以及后续的和testng、jenkins配合持续集成等

runAll.xml：这是testng的配置文件，用于存放部分测试数据以及测试的平台，浏览器的配置、加入第三方插件监听（arrow插件）、设置用例执行策略（多线程还是单线程，顺序执行还是无序执行以及是否依赖执行等）以及设置要执行的用例。之所以改成runAll顾名思义就是说执行整个web项目的所有模块的用例的测试
runSingle.xml：和runAll.xml一样，不多解释，不一样的地方就是用它来做单个用例的调试改错，只涉及到单个的类（用例），所以调试改错专用。比如我用runAll.xml跑完了所有的用例，但是发现个别用例失败，此时先去分析log，如果是代码问题就去调试代码，调试完毕之后就去用runSingle.xml去跑一边此用例。
default.xml: 只存储了测试参数（parameter）以及监听器（arrow），没有任何测试用例放在里面，这个xml文件是为了本框架的一个默认testng配置文件，主要是为了，直接在测试用例中右键运行测试用例，如果不配置一个默认的文件

主要是为了，直接在测试用例中右键运行测试用例，如果不配置一个默认的文件，直接在测试用例类中直接运行会跳过用例。因为xml文件中存储了一些必须的参数，比如测试浏览器是什么，测试平台是什么等等。框架搭建过程中会讲到如何设置default.xml文件。
runSmoke.xml：这个主要执行冒烟测试用的，冒烟测试我们会先一些基本和核心功能作为测试重点，迅速跑一遍这些功能点，看看这个软件版本能不能released。

##################################################
顺序说明：
01.AppiumUtil.java			appium api封装   
02.LogConfiguration.java	处理日志的工具类
03.SelectDriver.java		根据测试平台的不同，生成不同的driver，比如：AndroidDriver,iOSDriver
04.PropertiesDataProvider.java	从.properties文件中读取相关测试数据
05.BasePrepare.java			启动和结束测试，以及数据提供者，提供测试数据
06.ExcelDataProvider.java	读取Excel数据

Html监听报告解析
07.ConfigReader.java	实现失败的用例重跑，失败用例截图，生成更直观的HTML报告
08.TestResultListener.java	实现测试用例监听，负责监听测试运行状态和结果，保存截图文件
09.RetryListener.java 负责失败的用例重新执行的监听器
10.TestngRetry.java		实现能够有机会重试失败的测试
10.PowerEmailableReporter.java 负责生成测试报告的监听器

Excel监听报告解析
11.CreateExcelForResult	创建测试结果excel文件
12.ExcelReporter	excel报告
13.TestResultListener	测试结果监听

页面类设计：
13.HomePage 每一个page类对应一个页面，比如首页对应的是HomePage页面。每个页面里面都存放的是对于页面的元素定位

页面帮助类：
14.HomePageHelper 页面帮助类是为了专门封装这个页面上的操作

主测试用例：
15.SearchPage_001_SearchDemo_Test  需要继承BasePrepare。主测试用例里面，都是由各个页面帮助类来调用对应的页面操作方法，每个页面帮助类只写和本页面有关的方法，不要夹杂其他页面的方法，页面帮助类的方法，是调用AppiumUtil封装好的api

断言失败不中断继续执行:
Assertion:重写断言类，将testng断言放在try语句中，然后catch（Error）{}
AssertListener:监听器


完善测试参数和配置
1、为了避免TestNg在执行完一个package后，直接跳出不进行下面的测试用例，需要将Appium在Genarel Setting那里设置覆盖Session，即勾选上Override Existing Session选项

提交到github


