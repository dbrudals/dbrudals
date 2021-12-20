package com.swh.lombok;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Lombok1 {
      private String id;
      private String parentId;
      private String name;
      private Long depthLevel;
      private Long seq;
      private String userYn;
};