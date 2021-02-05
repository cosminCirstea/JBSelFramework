This is a framework built with JBehave

The structure is split into a few parts, as follows:

1. The story files. They usually live under "resources". In this example, they are in the package called stories from resources, module test. The story files contains scenarios written using plain English following the given/when/then syntax (gherkin).

2. The JBehave configs for story mapping. They live in the test module, in the bdd.setup package. StoryMapper is the parent class that all glue classes for running tests, either individual or suites. The default glue of the StoryMapper is to run all the tests.

3. The glue classes linking the story files with the implementation steps. They live in the test module, in the tests package. Their purpose is to link the story files with the steps classes that implement the given/when/then from the story files. This is done by specifying the location of the story files and the name of the appropriate steps classes. Be careful to also include the steps classes where the WebDriver is initiated. In this example, the class StoryBasic takes care of initiating and quiting the WebDriver using JBehave @BeforeClass / @AfterClass annotations.

4. The test setup classes concerning the WebDriver instantiation + WebDriver and Test data sharing between the steps classes. They live in the main module, under the steps.setup package. Bear in mind that the BaseSteps needs to be inherited by all steps classes, including StoryBasic in this case, where the WebDriver instantiation is not done in a given/when/then step, but by using JBehave annotations. See point 3.

5. The steps classes containing the implementation of the given/when/then steps; the "what to do". They live in the main module, under the steps package. Under the current structure, steps classes can either match the story files 1 to 1, or they can be specialized, covering steps for specific parts of the application, multiple story files being able to use their implementation.

6. The page object classes containing the WebElements and their behavior; the "how to do". They live in the main module, under the pages package. PageFactoryUtils class is used to instantiate them, so whenever you build a new Page class, you can add its getter there.

7. Utility classes that can be used to read property files, test data, etc. They live in the main module, under the utilities package.

Please bear in mind that this is just an example of structuring a framework, and you can adapt it according to your project's specific needs.
