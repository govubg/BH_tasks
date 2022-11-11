package prac;

public class paralleltest {
// link - https://www.youtube.com/watch?v=WZfh6v53leA
	
//	difference between cross browser and parallel is cross browser will run the test cases individually
//	after compleetig in one then it runs in other browser (one by one browsers)
	
	
	// while parallel test
	
	// - runs paralley in all the provided browsers.
	
	               // difference is code is just in xml file.
	
	               // below is for cross brwser
	
	
                  /*	<?xml version="1.0" encoding="UTF-8"?>
	                    <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
	                    <suite name="Suite" parallel="none">
	 	                   <test name="chrome">
	 	                   		<parameter name="browser" value= "chrome" />
	 		                   	<classes>
	 		                   		<class name="prac.MultiBrowser_crossbrowser" />
	 			                   </classes>
	 		                   </test>
	 		                   <test name="FirefoxTest">
 		                          <parameter name="browser" value="firefox" />
 		                        <classes>
 			                   <class name="prac.MultiBrowser_crossbrowser" />
 		                       </classes>
 	                            </test>
		                   </suite> <!-- Default suite -->  
	              */
	
	
	
                        // below is for parallel test
	
	
                       /*	<?xml version="1.0" encoding="UTF-8"?>
                           <!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
                           <suite name="Suite" parallel="tests">
                            <test name="chrome">
              		       <parameter name="browser" value= "chrome" />
                  	       <classes>
                  		    <class name="prac.MultiBrowser_crossbrowser" />
	                        </classes>
                            </test>
                            	 		                  
	 		                   <test name="FirefoxTest">
 		                          <parameter name="browser" value="firefox" />
 		                        <classes>
 			                   <class name="prac.MultiBrowser_crossbrowser" />
 		                       </classes>
 	                            </test>

                           </suite> <!-- Default suite -->  
                      */
	
	// rest all are same as cross browsers.
}
