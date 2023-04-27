;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/.
;;
;; Copyright (c) KALEIDOS INC

(ns app.main.ui.components.title-bar
  (:require-macros [app.main.style :refer [css]])
  (:require
   [app.main.ui.icons :as i]
   [app.util.dom :as dom]
   [rumext.v2 :as mf]))

(mf/defc title-bar
  [{:keys [collapse-button? collapsed? collapse-action title children button-action button-icon] :as props}]
  [:div {:class (dom/classnames (css :title-bar) true)}
   (if collapse-button?
     [:button {:class (dom/classnames (css :toggle-btn) true)
               :on-click collapse-action}
      [:span {:class (dom/classnames (css :collased-icon) true
                                     (css :rotated) collapsed?)}
       i/arrow-refactor]
      [:div {:class (dom/classnames (css :title) true)}
       title]]
     [:div {:class (dom/classnames (css :title-only) true)}
      title])
   (when (some? children)
     children)
   (when (some? button-icon)
     [:button {:class (dom/classnames (css :title-button) true)
               :on-click button-action}
      button-icon])])