Page({
  data: {
    address: '',
    //引入两个图标
    markers: [{
      id: 0,
      latitude: 40.0050,
      longitude: 116.3250,
      iconPath: '/images/map2.png',
      width: 25,
      height: 25
    }],
    markers1: [{
      id: 1,
      latitude: 39.99,
      longitude: 116.3130,
      iconPath: '/images/map2.png',
      width: 25,
      height: 25
    }],

  },
  onLoad: function (options) {
    var that = this;
    wx.getLocation({
      success: function (res) {
        console.log(res);
        that.setData({
          markers: [{
              id: 0,
              latitude: 40.0050,
              longitude: 116.3250,
              iconPath: '/images/map2.png',
              width: 25,
              height: 25
            },
            {
              id: 1,
              latitude: 39.99,
              longitude: 116.3130,
              iconPath: '/images/map2.png',
              width: 25,
              height: 25
            }
          ],
          //连线
          polyline: [{
            points: [{
                latitude: 40.0050,
                longitude: 116.3250,
              },
              {
                latitude: 39.99,
                longitude: 116.3130,
              }
            ],
            color: '#1E90FF',
            width: 2,
          }]

        })
      },
    })
  },
})