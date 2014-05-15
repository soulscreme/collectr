// @SOURCE:/Users/soulscreme/Dropbox/Programming/play-examples/collectr/conf/routes
// @HASH:7923e8203f9c0bd15145a21a126e1dd3842fe28d
// @DATE:Wed May 14 19:45:33 EDT 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def addMediaItemSrvc(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addMediaItem")
}
                                                

// @LINE:7
// @LINE:6
def itemManager(): Call = {
   () match {
// @LINE:6
case () if true => Call("GET", _prefix)
                                                        
// @LINE:7
case () if true => Call("GET", _prefix + { _defaultPrefix } + "addMediaItem")
                                                        
   }
}
                                                
    
}
                          
}
                  


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def addMediaItemSrvc : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.addMediaItemSrvc",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addMediaItem"})
      }
   """
)
                        

// @LINE:7
// @LINE:6
def itemManager : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.itemManager",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "addMediaItem"})
      }
      }
   """
)
                        
    
}
              
}
        


// @LINE:11
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:11
class ReverseAssets {
    

// @LINE:11
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def addMediaItemSrvc(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.addMediaItemSrvc(), HandlerDef(this, "controllers.Application", "addMediaItemSrvc", Seq(), "POST", """""", _prefix + """addMediaItem""")
)
                      

// @LINE:6
def itemManager(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.itemManager(), HandlerDef(this, "controllers.Application", "itemManager", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        
    