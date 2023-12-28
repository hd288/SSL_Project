import React, { useState } from "react";
import { Container } from "react-bootstrap";
import Slider from "react-slick";
import SliderChild from "./single-component";

export default function SingleCarousel() {
  const [settings] = useState({
    dots: true,
    infinite: true,
    speed: 100,
    slidesToShow: 1,
    slidesToScroll: 1,
    autoplay: true,
    speed: 1000,
    autoplaySpeed: 5000,
    pauseOnHover: true,
  });

  const data = [
    {
      title: "Top 6 mẹo của PHP giúp anh em code tốt hơn.",
      content:
        "Học lập trình chính quy, bài bản, từ A tới Z nhưng đôi khi anh em quên mất ngôn ngữ lập trình nào cũng có tip và trick. Tip và trick là những lưu ý nhỏ đôi khi anh em quên mất, nhưng chính tip với trick nho nhỏ đó đôi khi lại giúp đỡ anh em rất nhiều..",
      link: "https://topdev.vn/blog/meo-cua-php/",
    },
    {
      title: "So sánh Data Analyst với Business Analyst, nên chọn cái nào?",
      content:
        "Data Analyst và Business Analyst là 2 vị trí công việc khác nhau nhưng thường hay bị nhầm lẫn vai trò, chủ yếu là do đều cùng chức danh là nhà phân tích...",
      link: "https://topdev.vn/blog/so-sanh-data-analyst-voi-business-analyst/",
    },
    {
      title:
        "SharePoint Developer là gì? Cần học gì để trở thành lập trình viên SharePoint.",
      content:
        "Ra đời từ đầu những năm 2001, SharePoint được Microsoft giới thiệu với mục đích chủ yếu là để lưu trữ và quản lý tài liệu trong doanh nghiệp, tổ chức...",
      link: "https://topdev.vn/blog/sharepoint-developer-la-gi/",
    },
    {
      title: "Tìm hiểu về phong cách Point-Free trong JavaScript.",
      content:
        "Lần đầu tiếp xúc với phong cách này, tôi khá là bối rối. toJSON, handleResult, handleError ở đây là gì?",
      link: "https://topdev.vn/blog/phong-cach-point-free/",
    },
    {
      title: "Lộ trình học React Native từ A đến Z hiệu quả nhất!",
      content:
        "Lộ trình học React Native như nào là câu hỏi nhiều anh em newbie khi bước chân vào build app với React Native cần biết...",
      link: "https://topdev.vn/blog/lo-trinh-hoc-react-native/",
    },
    {
      title: "Lộ trình trở thành Ruby Developer cho người mới bắt đầu",
      content:
        "Lorem ipsum dolor sit amet consectetur adipisicing elit. Qui animi esse vel incidunt voluptas sapiente in quas praesentium! Totam veniam, necessitatibus illum molestiae voluptatem laudantium cum quo amet eligendi perspiciatis.",
      link: "https://topdev.vn/blog/lo-trinh-tro-thanh-ruby-developer/",
    },
  ];

  return (
    <div className="my-5 w-100">
      <Slider {...settings}>
        {data.map((item, index) => (
          <SliderChild key={index} {...item} />
        ))}
      </Slider>
    </div>
  );
}
