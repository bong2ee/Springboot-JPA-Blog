let index = {
        init:function() {
            $("#btn-save").on("click",()=>{
                this.save();
            });
        },

        save: function() {
            //alert('user의 save함수 호출됨');
            let data = {
                username: $("#username").val(),
                password: $("#password").val(),
                email: $("#password").val()
            }

            console.log(data);
    }
}

index.init();