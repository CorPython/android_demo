Page({

  /**
  * 页面的初始数据
  */
  data: {
    jisuan: false,
    displayValue: "",
    step: "",
    caozuo: "",
    reO: 0.4,
    stepO: 1,
    stepsize: 90,
    resize: 40,
    erro: ""

  },

  /**
  * 生命周期函数--监听页面加载
  */
  onLoad: function (options) {

  },

  /**
  * 生命周期函数--监听页面初次渲染完成
  */
  onReady: function () {

  },

  /**
  * 生命周期函数--监听页面显示
  */
  onShow: function () {

  },

  /**
  * 生命周期函数--监听页面隐藏
  */
  onHide: function () {

  },

  /**
  * 生命周期函数--监听页面卸载
  */
  onUnload: function () {
    this.displayValue = "3";
  },

  /**
  * 页面相关事件处理函数--监听用户下拉动作
  */
  onPullDownRefresh: function () {

  },

  /**
  * 页面上拉触底事件的处理函数
  */
  onReachBottom: function () {

  },

  /**
  * 用户点击右上角分享
  */
  onShareAppMessage: function () {

  },
  tap: function (e) {
    let some = e.currentTarget.dataset.value

    if (this.data.displayValue != "" || this.data.erro != "") {
      this.setData({
        jisuan: false,
        displayValue: "",
        step: "",
        caozuo: "",
        reO: 0.4,
        stepO: 1,
        stepsize: 90,
        resize: 40,
        erro: ""

      });
    }
    switch (some) {
      case 'AC': this.setData({
        jisuan: false,
        displayValue: "",
        step: "",
        caozuo: "",
        reO: 0.4,
        stepO: 1,
        stepsize: 90,
        resize: 40,
        erro: ""

      }); break;
      case 'DEL': var stp = this.data.step.slice(0, -1);
        this.setData({
          step: stp
        }); break;
      case '=':
        var num = this.data.step.split(this.data.caozuo)
        switch (this.data.caozuo) {
          case '+': var de = (parseFloat(num[0]) + parseFloat(num[1])).toFixed(5); break;
          case '-': var de = (parseFloat(num[0]) - parseFloat(num[1])).toFixed(5); break;
          case '*': var de = parseFloat(num[0]) * parseFloat(num[1]); break;
          case '%': var de = parseFloat(num[0]) % parseFloat(num[1]);break;
          case '/': if (parseFloat(num[1]) == 0) {
            this.setData({
              erro: "除数不能为零",
              some: "AC"
            });
            var de = "除数不可以为零"
            break;
          }
            var de = parseFloat(num[0]) / parseFloat(num[1]); break;
          default: de = num;
        }
        this.setData({
          reO: 1,
          stepO: 0.4,
          stepsize: 40,
          resize: 90,
          displayValue: de

        }); break;
      case '%':
      case '+':
      case '-':
      case '*':
      case '/': if (this.data.jisuan) {

        var num = this.data.step.split(this.data.caozuo)
        if (num[0] == "" || num[1] == "") {
          this.setData({
            erro: "输入错误",
          })

          break;
        }
        else {
          switch (this.data.caozuo) {
            case '+': var de = parseFloat(num[0]) + parseFloat(num[1]); break;
            case '-': var de = parseFloat(num[0]) - parseFloat(num[1]); break;
            case '*': var de = parseFloat(num[0]) * parseFloat(num[1]); break;
            case '/': if (parseFloat(num[1]) == 0) {
              this.setData({
                erro: "除数不能为零",
              });
              break;

            }

              var de = parseFloat(num[0]) / parseFloat(num[1]);
              de += some
              this.setData({
                step: de,
                caozuo: some

              })
              break;
          }
          de += some
          this.setData({
            step: de,
            caozuo: some,
            jisuan: true

          })

        } break;
      }
      else {
        var ss = this.data.step
        ss += some
        this.setData({
          step: ss,
          caozuo: some,
          jisuan: true

        })
        break;
      }
      default: var ss = this.data.step
        ss += some
        this.setData({
          step: ss,

        })
        break;
    }

  }
})
