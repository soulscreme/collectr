
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object item_manager extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[MediaItem],List[MediaItem],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(newItemForm: Form[MediaItem], items: List[MediaItem]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.56*/("""

"""),format.raw/*4.1*/("""
<!DOCTYPE html>

<html>
    <head>
        <title>collectr Media List Management</title>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*10.46*/routes/*10.52*/.Assets.at("/javascripts/jquery-1.9.0.min.js"))),format.raw/*10.98*/(""""></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*11.46*/routes/*11.52*/.Assets.at("/javascripts/jquery-ui.min.js"))),format.raw/*11.95*/(""""></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*12.46*/routes/*12.52*/.Assets.at("/javascripts/jquery.ui.tabs.min.js"))),format.raw/*12.100*/(""""></script>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*13.54*/routes/*13.60*/.Assets.at("stylesheets/main.css"))),format.raw/*13.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*14.59*/routes/*14.65*/.Assets.at("images/favicon.png"))),format.raw/*14.97*/("""">
    </head>
    <body>
        <h1>Existing Media Items</h1>
        <table border="1">
            <tr>
                <td>Title</td>
                <td>Year</td>
                <td>Description</td>
                <td>Image</td>
            </tr>
            """),_display_(Seq[Any](/*25.14*/items/*25.19*/.map/*25.23*/ { item =>_display_(Seq[Any](format.raw/*25.33*/("""
                <tr>
                    <td>"""),_display_(Seq[Any](/*27.26*/item/*27.30*/.title)),format.raw/*27.36*/("""</td>
                    <td>"""),_display_(Seq[Any](/*28.26*/item/*28.30*/.year)),format.raw/*28.35*/("""</td>
                    <td>"""),_display_(Seq[Any](/*29.26*/item/*29.30*/.description)),format.raw/*29.42*/("""</td>
                    <td>"""),_display_(Seq[Any](/*30.26*/item/*30.30*/.image)),format.raw/*30.36*/("""</td>
                </tr>
            """)))})),format.raw/*32.14*/("""
        </table>

        <h1>Add Media Item</h1>

        """),_display_(Seq[Any](/*37.10*/helper/*37.16*/.form(action = routes.Application.addMediaItemSrvc())/*37.69*/ {_display_(Seq[Any](format.raw/*37.71*/("""
            """),_display_(Seq[Any](/*38.14*/helper/*38.20*/.inputText(field = newItemForm("title"), args = '_label -> "Title"))),format.raw/*38.87*/("""
            """),_display_(Seq[Any](/*39.14*/helper/*39.20*/.inputText(field = newItemForm("year"), args = 'size -> 4, '_label -> "Year"))),format.raw/*39.97*/("""
            """),_display_(Seq[Any](/*40.14*/helper/*40.20*/.textarea(field = newItemForm("description"), args = 'rows -> 5, 'cols -> 50, '_label -> "Description"))),format.raw/*40.123*/("""
            """),_display_(Seq[Any](/*41.14*/helper/*41.20*/.inputText(field = newItemForm("image"), args = '_label -> "Image"))),format.raw/*41.87*/("""
            <input type="submit" value="Add Item"/>
        """)))})),format.raw/*43.10*/("""
    </body>
</html>"""))}
    }
    
    def render(newItemForm:Form[MediaItem],items:List[MediaItem]): play.api.templates.HtmlFormat.Appendable = apply(newItemForm,items)
    
    def f:((Form[MediaItem],List[MediaItem]) => play.api.templates.HtmlFormat.Appendable) = (newItemForm,items) => apply(newItemForm,items)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed May 14 20:35:25 EDT 2014
                    SOURCE: /Users/soulscreme/Dropbox/Programming/play-examples/collectr/app/views/item_manager.scala.html
                    HASH: 8dcd25c4b198f2956d0ba90a5b89c74f1a6d9166
                    MATRIX: 588->1|752->55|780->74|951->209|966->215|1034->261|1127->318|1142->324|1207->367|1300->424|1315->430|1386->478|1487->543|1502->549|1558->583|1655->644|1670->650|1724->682|2028->950|2042->955|2055->959|2103->969|2186->1016|2199->1020|2227->1026|2294->1057|2307->1061|2334->1066|2401->1097|2414->1101|2448->1113|2515->1144|2528->1148|2556->1154|2629->1195|2726->1256|2741->1262|2803->1315|2843->1317|2893->1331|2908->1337|2997->1404|3047->1418|3062->1424|3161->1501|3211->1515|3226->1521|3352->1624|3402->1638|3417->1644|3506->1711|3600->1773
                    LINES: 19->1|23->1|25->4|31->10|31->10|31->10|32->11|32->11|32->11|33->12|33->12|33->12|34->13|34->13|34->13|35->14|35->14|35->14|46->25|46->25|46->25|46->25|48->27|48->27|48->27|49->28|49->28|49->28|50->29|50->29|50->29|51->30|51->30|51->30|53->32|58->37|58->37|58->37|58->37|59->38|59->38|59->38|60->39|60->39|60->39|61->40|61->40|61->40|62->41|62->41|62->41|64->43
                    -- GENERATED --
                */
            