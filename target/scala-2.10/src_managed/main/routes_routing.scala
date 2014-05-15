// @SOURCE:/Users/soulscreme/Dropbox/Programming/play-examples/collectr/conf/routes
// @HASH:7923e8203f9c0bd15145a21a126e1dd3842fe28d
// @DATE:Wed May 14 19:45:33 EDT 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_itemManager0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_itemManager1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addMediaItem"))))
        

// @LINE:8
private[this] lazy val controllers_Application_addMediaItemSrvc2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addMediaItem"))))
        

// @LINE:11
private[this] lazy val controllers_Assets_at3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.itemManager"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addMediaItem""","""controllers.Application.itemManager"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addMediaItem""","""controllers.Application.addMediaItemSrvc"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_itemManager0(params) => {
   call { 
        invokeHandler(controllers.Application.itemManager, HandlerDef(this, "controllers.Application", "itemManager", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_itemManager1(params) => {
   call { 
        invokeHandler(controllers.Application.itemManager, HandlerDef(this, "controllers.Application", "itemManager", Nil,"GET", """""", Routes.prefix + """addMediaItem"""))
   }
}
        

// @LINE:8
case controllers_Application_addMediaItemSrvc2(params) => {
   call { 
        invokeHandler(controllers.Application.addMediaItemSrvc, HandlerDef(this, "controllers.Application", "addMediaItemSrvc", Nil,"POST", """""", Routes.prefix + """addMediaItem"""))
   }
}
        

// @LINE:11
case controllers_Assets_at3(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     