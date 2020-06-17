Page({
  data: {
    address: '',
    //引入两个图标
    markers: [
      {
        id: 0,
        latitude: 28.6510,
        longitude: 115.8285,
        iconPath: '/images/map2.png',
        width: 25,
        height: 25
      }
    ],
    markers1: [
      {
        id: 1,
        latitude: 28.6611,
        longitude: 115.8356,
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
          markers: [
            {
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
            }],
            //连线
          polyline: [{
            points: [{
              latitude: 40.0050,
              longitude: 116.3250,
            },
          {
            latitude: 39.99,
            longitude: 116.3130,
          }],
            color: '#800000',
            width: 2,
           }]

        })
      },
    })
    let plugin = requirePlugin('routePlan');
    let key = 'S6TBZ-N5J3F-M4CJQ-NZKH2-J62N2-QQFMK';
    let referer='17207136张福平';
    mode:'driving';
    let startPoint = JSON.stringify({
      'name': '清华大学',
      'latitude': 40.0050,
      'longitude': 116.3250,
    }
    );
    let endPoint = JSON.stringify({
      'name':'北京大学',
      'latitude': 39.99,
      'longitude': 116.3130,
    }
    );
    wx.navigateTo({
      url: 'plugin://routePlan/index?key=' + key + '&referer=' + referer + '&startPoint=' + startPoint + '&endPoint=' + endPoint
    });
  },
})
