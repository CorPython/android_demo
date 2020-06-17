Page({
  onReady: function (e) {
    // 使用 wx.createAudioContext 获取 audio 上下文 context
    this.audioCtx = wx.createAudioContext('myAudio')
  },
  data: {
    cardCur: 0,
    swiperList: [{
      id: 0,
      type: 'image',
      url: 'https://cdn.jsdelivr.net/gh/CorPython/images@master/img/20200128162059.png',
    }, {
      id: 1,
        type: 'image',
        url: 'http://cdn.knowempty.xyz//20200327130712.png',
    }, {
      id: 2,
      type: 'image',
      url: 'https://cdn.jsdelivr.net/gh/CorPython/images@master//img/20200305124506.png'
    }, {
      id: 3,
      type: 'image',
      url: 'https://cdn.jsdelivr.net/gh/CorPython/images@master/img/20200128183119.png'
    }, {
      id: 4,
      type: 'image',
      url: 'https://cdn.jsdelivr.net/gh/CorPython/images@master/img/20200128221930.png'
    }, {
      id: 5,
      type: 'image',
      url: 'https://cdn.jsdelivr.net/gh/CorPython/images@master/img/20200128193718.png'
    }, {
      id: 6,
      type: 'image',
      url: 'https://cdn.jsdelivr.net/gh/CorPython/images@master/img/20200128194431.png'
    }],
      poster: 'http://p2.music.126.net/HeGrAKPiZhKkONiFDxZvmw==/109951164384346866.jpg',
      name: '我爱我的祖国',
      author: '王菲',
      src: 'http://cdn.knowempty.xyz/我和我的祖国.mp3',
    audioPlay: function () {
      this.audioCtx.play()
    },
    audioPause: function () {
      this.audioCtx.pause()
    },
  },
  onLoad() {
    this.towerSwiper('swiperList');
    // 初始化towerSwiper 传已有的数组名即可
  },
  DotStyle(e) {
    this.setData({
      DotStyle: e.detail.value
    })
  },
  // cardSwiper
  cardSwiper(e) {
    this.setData({
      cardCur: e.detail.current
    })
  },
  // towerSwiper
  // 初始化towerSwiper
  towerSwiper(name) {
    let list = this.data[name];
    for (let i = 0; i < list.length; i++) {
      list[i].zIndex = parseInt(list.length / 2) + 1 - Math.abs(i - parseInt(list.length / 2))
      list[i].mLeft = i - parseInt(list.length / 2)
    }
    this.setData({
      swiperList: list
    })
  },
  // towerSwiper触摸开始
  towerStart(e) {
    this.setData({
      towerStart: e.touches[0].pageX
    })
  },
  // towerSwiper计算方向
  towerMove(e) {
    this.setData({
      direction: e.touches[0].pageX - this.data.towerStart > 0 ? 'right' : 'left'
    })
  },
  // towerSwiper计算滚动
  towerEnd(e) {
    let direction = this.data.direction;
    let list = this.data.swiperList;
    if (direction == 'right') {
      let mLeft = list[0].mLeft;
      let zIndex = list[0].zIndex;
      for (let i = 1; i < list.length; i++) {
        list[i - 1].mLeft = list[i].mLeft
        list[i - 1].zIndex = list[i].zIndex
      }
      list[list.length - 1].mLeft = mLeft;
      list[list.length - 1].zIndex = zIndex;
      this.setData({
        swiperList: list
      })
    } else {
      let mLeft = list[list.length - 1].mLeft;
      let zIndex = list[list.length - 1].zIndex;
      for (let i = list.length - 1; i > 0; i--) {
        list[i].mLeft = list[i - 1].mLeft
        list[i].zIndex = list[i - 1].zIndex
      }
      list[0].mLeft = mLeft;
      list[0].zIndex = zIndex;
      this.setData({
        swiperList: list
      })
    }
  }
})