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
      title: "Lorem ipsum dolor sit amet.",
      content:
        "Lorem ipsum dolor sit amet consectetur adipisicing elit. Qui animi esse vel incidunt voluptas sapiente in quas praesentium! Totam veniam, necessitatibus illum molestiae voluptatem laudantium cum quo amet eligendi perspiciatis.",
    },
    {
      title: "Lorem ipsum dolor sit amet.",
      content:
        "Lorem ipsum dolor sit amet consectetur adipisicing elit. Qui animi esse vel incidunt voluptas sapiente in quas praesentium! Totam veniam, necessitatibus illum molestiae voluptatem laudantium cum quo amet eligendi perspiciatis.",
    },
    {
      title: "Lorem ipsum dolor sit amet.",
      content:
        "Lorem ipsum dolor sit amet consectetur adipisicing elit. Qui animi esse vel incidunt voluptas sapiente in quas praesentium! Totam veniam, necessitatibus illum molestiae voluptatem laudantium cum quo amet eligendi perspiciatis.",
    },
    {
      title: "Lorem ipsum dolor sit amet.",
      content:
        "Lorem ipsum dolor sit amet consectetur adipisicing elit. Qui animi esse vel incidunt voluptas sapiente in quas praesentium! Totam veniam, necessitatibus illum molestiae voluptatem laudantium cum quo amet eligendi perspiciatis.",
    },
    {
      title: "Lorem ipsum dolor sit amet.",
      content:
        "Lorem ipsum dolor sit amet consectetur adipisicing elit. Qui animi esse vel incidunt voluptas sapiente in quas praesentium! Totam veniam, necessitatibus illum molestiae voluptatem laudantium cum quo amet eligendi perspiciatis.",
    },
    {
      title: "Lorem ipsum dolor sit amet.",
      content:
        "Lorem ipsum dolor sit amet consectetur adipisicing elit. Qui animi esse vel incidunt voluptas sapiente in quas praesentium! Totam veniam, necessitatibus illum molestiae voluptatem laudantium cum quo amet eligendi perspiciatis.",
    },
  ];

  return (
    <div className="my-5 w-100">
      <Slider {...settings} >
        {data.map((item, index) => (
          <SliderChild key={index} {...item} />
        ))}
      </Slider>
    </div>
  );
}
