package model

data class User( val userId:String,
                 @get:PropertyName("DisplayName")
                 @set:PropertyName("DisplayName")
                 var displayname:String="",


                 @get:PropertyName("email")
                 @set:PropertyName("email")
                 var email:String ="",

                 @get:PropertyName("location")
                 @set:PropertyName("location")
                 var connectedprsn:String =""
){
    constructor():this("","","")
}
