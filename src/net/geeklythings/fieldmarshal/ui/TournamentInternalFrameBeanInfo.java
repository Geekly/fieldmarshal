/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.geeklythings.fieldmarshal.ui;

import java.beans.*;

/**
 *
 * @author khooks
 */
public class TournamentInternalFrameBeanInfo extends SimpleBeanInfo {

    // Bean descriptor//GEN-FIRST:BeanDescriptor
    /*lazy BeanDescriptor*/
    private static BeanDescriptor getBdescriptor(){
        BeanDescriptor beanDescriptor = new BeanDescriptor  ( net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class , null ); // NOI18N//GEN-HEADEREND:BeanDescriptor

        // Here you can add code for customizing the BeanDescriptor.

        return beanDescriptor;     }//GEN-LAST:BeanDescriptor
    // Property identifiers//GEN-FIRST:Properties
    private static final int PROPERTY_accessibleContext = 0;
    private static final int PROPERTY_actionMap = 1;
    private static final int PROPERTY_activeTournament = 2;
    private static final int PROPERTY_alignmentX = 3;
    private static final int PROPERTY_alignmentY = 4;
    private static final int PROPERTY_ancestorListeners = 5;
    private static final int PROPERTY_autoscrolls = 6;
    private static final int PROPERTY_background = 7;
    private static final int PROPERTY_backgroundSet = 8;
    private static final int PROPERTY_baselineResizeBehavior = 9;
    private static final int PROPERTY_border = 10;
    private static final int PROPERTY_bounds = 11;
    private static final int PROPERTY_closable = 12;
    private static final int PROPERTY_closed = 13;
    private static final int PROPERTY_colorModel = 14;
    private static final int PROPERTY_component = 15;
    private static final int PROPERTY_componentCount = 16;
    private static final int PROPERTY_componentListeners = 17;
    private static final int PROPERTY_componentOrientation = 18;
    private static final int PROPERTY_componentPopupMenu = 19;
    private static final int PROPERTY_components = 20;
    private static final int PROPERTY_containerListeners = 21;
    private static final int PROPERTY_contentPane = 22;
    private static final int PROPERTY_cursor = 23;
    private static final int PROPERTY_cursorSet = 24;
    private static final int PROPERTY_debugGraphicsOptions = 25;
    private static final int PROPERTY_defaultCloseOperation = 26;
    private static final int PROPERTY_desktopIcon = 27;
    private static final int PROPERTY_desktopPane = 28;
    private static final int PROPERTY_displayable = 29;
    private static final int PROPERTY_doubleBuffered = 30;
    private static final int PROPERTY_dropTarget = 31;
    private static final int PROPERTY_enabled = 32;
    private static final int PROPERTY_focusable = 33;
    private static final int PROPERTY_focusCycleRoot = 34;
    private static final int PROPERTY_focusCycleRootAncestor = 35;
    private static final int PROPERTY_focusListeners = 36;
    private static final int PROPERTY_focusOwner = 37;
    private static final int PROPERTY_focusTraversable = 38;
    private static final int PROPERTY_focusTraversalKeys = 39;
    private static final int PROPERTY_focusTraversalKeysEnabled = 40;
    private static final int PROPERTY_focusTraversalPolicy = 41;
    private static final int PROPERTY_focusTraversalPolicyProvider = 42;
    private static final int PROPERTY_focusTraversalPolicySet = 43;
    private static final int PROPERTY_font = 44;
    private static final int PROPERTY_fontSet = 45;
    private static final int PROPERTY_foreground = 46;
    private static final int PROPERTY_foregroundSet = 47;
    private static final int PROPERTY_frameIcon = 48;
    private static final int PROPERTY_glassPane = 49;
    private static final int PROPERTY_graphics = 50;
    private static final int PROPERTY_graphicsConfiguration = 51;
    private static final int PROPERTY_height = 52;
    private static final int PROPERTY_hierarchyBoundsListeners = 53;
    private static final int PROPERTY_hierarchyListeners = 54;
    private static final int PROPERTY_icon = 55;
    private static final int PROPERTY_iconifiable = 56;
    private static final int PROPERTY_ignoreRepaint = 57;
    private static final int PROPERTY_inheritsPopupMenu = 58;
    private static final int PROPERTY_inputContext = 59;
    private static final int PROPERTY_inputMap = 60;
    private static final int PROPERTY_inputMethodListeners = 61;
    private static final int PROPERTY_inputMethodRequests = 62;
    private static final int PROPERTY_inputVerifier = 63;
    private static final int PROPERTY_insets = 64;
    private static final int PROPERTY_internalFrameListeners = 65;
    private static final int PROPERTY_JMenuBar = 66;
    private static final int PROPERTY_keyListeners = 67;
    private static final int PROPERTY_lastCursor = 68;
    private static final int PROPERTY_layer = 69;
    private static final int PROPERTY_layeredPane = 70;
    private static final int PROPERTY_layout = 71;
    private static final int PROPERTY_lightweight = 72;
    private static final int PROPERTY_locale = 73;
    private static final int PROPERTY_location = 74;
    private static final int PROPERTY_locationOnScreen = 75;
    private static final int PROPERTY_managingFocus = 76;
    private static final int PROPERTY_maximizable = 77;
    private static final int PROPERTY_maximum = 78;
    private static final int PROPERTY_maximumSize = 79;
    private static final int PROPERTY_maximumSizeSet = 80;
    private static final int PROPERTY_menuBar = 81;
    private static final int PROPERTY_minimumSize = 82;
    private static final int PROPERTY_minimumSizeSet = 83;
    private static final int PROPERTY_mostRecentFocusOwner = 84;
    private static final int PROPERTY_mouseListeners = 85;
    private static final int PROPERTY_mouseMotionListeners = 86;
    private static final int PROPERTY_mousePosition = 87;
    private static final int PROPERTY_mouseWheelListeners = 88;
    private static final int PROPERTY_name = 89;
    private static final int PROPERTY_nextFocusableComponent = 90;
    private static final int PROPERTY_normalBounds = 91;
    private static final int PROPERTY_opaque = 92;
    private static final int PROPERTY_optimizedDrawingEnabled = 93;
    private static final int PROPERTY_paintingForPrint = 94;
    private static final int PROPERTY_paintingTile = 95;
    private static final int PROPERTY_parent = 96;
    private static final int PROPERTY_peer = 97;
    private static final int PROPERTY_preferredSize = 98;
    private static final int PROPERTY_preferredSizeSet = 99;
    private static final int PROPERTY_propertyChangeListeners = 100;
    private static final int PROPERTY_registeredKeyStrokes = 101;
    private static final int PROPERTY_requestFocusEnabled = 102;
    private static final int PROPERTY_resizable = 103;
    private static final int PROPERTY_rootPane = 104;
    private static final int PROPERTY_selected = 105;
    private static final int PROPERTY_showing = 106;
    private static final int PROPERTY_size = 107;
    private static final int PROPERTY_title = 108;
    private static final int PROPERTY_toolkit = 109;
    private static final int PROPERTY_toolTipText = 110;
    private static final int PROPERTY_topLevelAncestor = 111;
    private static final int PROPERTY_transferHandler = 112;
    private static final int PROPERTY_treeLock = 113;
    private static final int PROPERTY_UI = 114;
    private static final int PROPERTY_UIClassID = 115;
    private static final int PROPERTY_valid = 116;
    private static final int PROPERTY_validateRoot = 117;
    private static final int PROPERTY_verifyInputWhenFocusTarget = 118;
    private static final int PROPERTY_vetoableChangeListeners = 119;
    private static final int PROPERTY_visible = 120;
    private static final int PROPERTY_visibleRect = 121;
    private static final int PROPERTY_warningString = 122;
    private static final int PROPERTY_width = 123;
    private static final int PROPERTY_x = 124;
    private static final int PROPERTY_y = 125;

    // Property array 
    /*lazy PropertyDescriptor*/
    private static PropertyDescriptor[] getPdescriptor(){
        PropertyDescriptor[] properties = new PropertyDescriptor[126];
    
        try {
            properties[PROPERTY_accessibleContext] = new PropertyDescriptor ( "accessibleContext", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getAccessibleContext", null ); // NOI18N
            properties[PROPERTY_actionMap] = new PropertyDescriptor ( "actionMap", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getActionMap", "setActionMap" ); // NOI18N
            properties[PROPERTY_activeTournament] = new PropertyDescriptor ( "activeTournament", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getActiveTournament", "setActiveTournament" ); // NOI18N
            properties[PROPERTY_alignmentX] = new PropertyDescriptor ( "alignmentX", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getAlignmentX", "setAlignmentX" ); // NOI18N
            properties[PROPERTY_alignmentY] = new PropertyDescriptor ( "alignmentY", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getAlignmentY", "setAlignmentY" ); // NOI18N
            properties[PROPERTY_ancestorListeners] = new PropertyDescriptor ( "ancestorListeners", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getAncestorListeners", null ); // NOI18N
            properties[PROPERTY_autoscrolls] = new PropertyDescriptor ( "autoscrolls", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getAutoscrolls", "setAutoscrolls" ); // NOI18N
            properties[PROPERTY_background] = new PropertyDescriptor ( "background", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getBackground", "setBackground" ); // NOI18N
            properties[PROPERTY_backgroundSet] = new PropertyDescriptor ( "backgroundSet", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isBackgroundSet", null ); // NOI18N
            properties[PROPERTY_baselineResizeBehavior] = new PropertyDescriptor ( "baselineResizeBehavior", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getBaselineResizeBehavior", null ); // NOI18N
            properties[PROPERTY_border] = new PropertyDescriptor ( "border", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getBorder", "setBorder" ); // NOI18N
            properties[PROPERTY_bounds] = new PropertyDescriptor ( "bounds", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getBounds", "setBounds" ); // NOI18N
            properties[PROPERTY_closable] = new PropertyDescriptor ( "closable", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isClosable", "setClosable" ); // NOI18N
            properties[PROPERTY_closed] = new PropertyDescriptor ( "closed", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isClosed", "setClosed" ); // NOI18N
            properties[PROPERTY_colorModel] = new PropertyDescriptor ( "colorModel", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getColorModel", null ); // NOI18N
            properties[PROPERTY_component] = new IndexedPropertyDescriptor ( "component", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, null, null, "getComponent", null ); // NOI18N
            properties[PROPERTY_componentCount] = new PropertyDescriptor ( "componentCount", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getComponentCount", null ); // NOI18N
            properties[PROPERTY_componentListeners] = new PropertyDescriptor ( "componentListeners", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getComponentListeners", null ); // NOI18N
            properties[PROPERTY_componentOrientation] = new PropertyDescriptor ( "componentOrientation", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getComponentOrientation", "setComponentOrientation" ); // NOI18N
            properties[PROPERTY_componentPopupMenu] = new PropertyDescriptor ( "componentPopupMenu", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getComponentPopupMenu", "setComponentPopupMenu" ); // NOI18N
            properties[PROPERTY_components] = new PropertyDescriptor ( "components", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getComponents", null ); // NOI18N
            properties[PROPERTY_containerListeners] = new PropertyDescriptor ( "containerListeners", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getContainerListeners", null ); // NOI18N
            properties[PROPERTY_contentPane] = new PropertyDescriptor ( "contentPane", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getContentPane", "setContentPane" ); // NOI18N
            properties[PROPERTY_cursor] = new PropertyDescriptor ( "cursor", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getCursor", "setCursor" ); // NOI18N
            properties[PROPERTY_cursorSet] = new PropertyDescriptor ( "cursorSet", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isCursorSet", null ); // NOI18N
            properties[PROPERTY_debugGraphicsOptions] = new PropertyDescriptor ( "debugGraphicsOptions", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getDebugGraphicsOptions", "setDebugGraphicsOptions" ); // NOI18N
            properties[PROPERTY_defaultCloseOperation] = new PropertyDescriptor ( "defaultCloseOperation", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getDefaultCloseOperation", "setDefaultCloseOperation" ); // NOI18N
            properties[PROPERTY_desktopIcon] = new PropertyDescriptor ( "desktopIcon", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getDesktopIcon", "setDesktopIcon" ); // NOI18N
            properties[PROPERTY_desktopPane] = new PropertyDescriptor ( "desktopPane", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getDesktopPane", null ); // NOI18N
            properties[PROPERTY_displayable] = new PropertyDescriptor ( "displayable", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isDisplayable", null ); // NOI18N
            properties[PROPERTY_doubleBuffered] = new PropertyDescriptor ( "doubleBuffered", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isDoubleBuffered", "setDoubleBuffered" ); // NOI18N
            properties[PROPERTY_dropTarget] = new PropertyDescriptor ( "dropTarget", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getDropTarget", "setDropTarget" ); // NOI18N
            properties[PROPERTY_enabled] = new PropertyDescriptor ( "enabled", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isEnabled", "setEnabled" ); // NOI18N
            properties[PROPERTY_focusable] = new PropertyDescriptor ( "focusable", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isFocusable", "setFocusable" ); // NOI18N
            properties[PROPERTY_focusCycleRoot] = new PropertyDescriptor ( "focusCycleRoot", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isFocusCycleRoot", "setFocusCycleRoot" ); // NOI18N
            properties[PROPERTY_focusCycleRootAncestor] = new PropertyDescriptor ( "focusCycleRootAncestor", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getFocusCycleRootAncestor", null ); // NOI18N
            properties[PROPERTY_focusListeners] = new PropertyDescriptor ( "focusListeners", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getFocusListeners", null ); // NOI18N
            properties[PROPERTY_focusOwner] = new PropertyDescriptor ( "focusOwner", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getFocusOwner", null ); // NOI18N
            properties[PROPERTY_focusTraversable] = new PropertyDescriptor ( "focusTraversable", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isFocusTraversable", null ); // NOI18N
            properties[PROPERTY_focusTraversalKeys] = new IndexedPropertyDescriptor ( "focusTraversalKeys", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, null, null, null, "setFocusTraversalKeys" ); // NOI18N
            properties[PROPERTY_focusTraversalKeysEnabled] = new PropertyDescriptor ( "focusTraversalKeysEnabled", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getFocusTraversalKeysEnabled", "setFocusTraversalKeysEnabled" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicy] = new PropertyDescriptor ( "focusTraversalPolicy", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getFocusTraversalPolicy", "setFocusTraversalPolicy" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicyProvider] = new PropertyDescriptor ( "focusTraversalPolicyProvider", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isFocusTraversalPolicyProvider", "setFocusTraversalPolicyProvider" ); // NOI18N
            properties[PROPERTY_focusTraversalPolicySet] = new PropertyDescriptor ( "focusTraversalPolicySet", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isFocusTraversalPolicySet", null ); // NOI18N
            properties[PROPERTY_font] = new PropertyDescriptor ( "font", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getFont", "setFont" ); // NOI18N
            properties[PROPERTY_fontSet] = new PropertyDescriptor ( "fontSet", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isFontSet", null ); // NOI18N
            properties[PROPERTY_foreground] = new PropertyDescriptor ( "foreground", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getForeground", "setForeground" ); // NOI18N
            properties[PROPERTY_foregroundSet] = new PropertyDescriptor ( "foregroundSet", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isForegroundSet", null ); // NOI18N
            properties[PROPERTY_frameIcon] = new PropertyDescriptor ( "frameIcon", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getFrameIcon", "setFrameIcon" ); // NOI18N
            properties[PROPERTY_glassPane] = new PropertyDescriptor ( "glassPane", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getGlassPane", "setGlassPane" ); // NOI18N
            properties[PROPERTY_graphics] = new PropertyDescriptor ( "graphics", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getGraphics", null ); // NOI18N
            properties[PROPERTY_graphicsConfiguration] = new PropertyDescriptor ( "graphicsConfiguration", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getGraphicsConfiguration", null ); // NOI18N
            properties[PROPERTY_height] = new PropertyDescriptor ( "height", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getHeight", null ); // NOI18N
            properties[PROPERTY_hierarchyBoundsListeners] = new PropertyDescriptor ( "hierarchyBoundsListeners", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getHierarchyBoundsListeners", null ); // NOI18N
            properties[PROPERTY_hierarchyListeners] = new PropertyDescriptor ( "hierarchyListeners", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getHierarchyListeners", null ); // NOI18N
            properties[PROPERTY_icon] = new PropertyDescriptor ( "icon", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isIcon", "setIcon" ); // NOI18N
            properties[PROPERTY_iconifiable] = new PropertyDescriptor ( "iconifiable", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isIconifiable", "setIconifiable" ); // NOI18N
            properties[PROPERTY_ignoreRepaint] = new PropertyDescriptor ( "ignoreRepaint", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getIgnoreRepaint", "setIgnoreRepaint" ); // NOI18N
            properties[PROPERTY_inheritsPopupMenu] = new PropertyDescriptor ( "inheritsPopupMenu", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getInheritsPopupMenu", "setInheritsPopupMenu" ); // NOI18N
            properties[PROPERTY_inputContext] = new PropertyDescriptor ( "inputContext", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getInputContext", null ); // NOI18N
            properties[PROPERTY_inputMap] = new PropertyDescriptor ( "inputMap", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getInputMap", null ); // NOI18N
            properties[PROPERTY_inputMethodListeners] = new PropertyDescriptor ( "inputMethodListeners", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getInputMethodListeners", null ); // NOI18N
            properties[PROPERTY_inputMethodRequests] = new PropertyDescriptor ( "inputMethodRequests", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getInputMethodRequests", null ); // NOI18N
            properties[PROPERTY_inputVerifier] = new PropertyDescriptor ( "inputVerifier", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getInputVerifier", "setInputVerifier" ); // NOI18N
            properties[PROPERTY_insets] = new PropertyDescriptor ( "insets", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getInsets", null ); // NOI18N
            properties[PROPERTY_internalFrameListeners] = new PropertyDescriptor ( "internalFrameListeners", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getInternalFrameListeners", null ); // NOI18N
            properties[PROPERTY_JMenuBar] = new PropertyDescriptor ( "JMenuBar", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getJMenuBar", "setJMenuBar" ); // NOI18N
            properties[PROPERTY_keyListeners] = new PropertyDescriptor ( "keyListeners", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getKeyListeners", null ); // NOI18N
            properties[PROPERTY_lastCursor] = new PropertyDescriptor ( "lastCursor", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getLastCursor", null ); // NOI18N
            properties[PROPERTY_layer] = new PropertyDescriptor ( "layer", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getLayer", "setLayer" ); // NOI18N
            properties[PROPERTY_layeredPane] = new PropertyDescriptor ( "layeredPane", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getLayeredPane", "setLayeredPane" ); // NOI18N
            properties[PROPERTY_layout] = new PropertyDescriptor ( "layout", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getLayout", "setLayout" ); // NOI18N
            properties[PROPERTY_lightweight] = new PropertyDescriptor ( "lightweight", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isLightweight", null ); // NOI18N
            properties[PROPERTY_locale] = new PropertyDescriptor ( "locale", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getLocale", "setLocale" ); // NOI18N
            properties[PROPERTY_location] = new PropertyDescriptor ( "location", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getLocation", "setLocation" ); // NOI18N
            properties[PROPERTY_locationOnScreen] = new PropertyDescriptor ( "locationOnScreen", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getLocationOnScreen", null ); // NOI18N
            properties[PROPERTY_managingFocus] = new PropertyDescriptor ( "managingFocus", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isManagingFocus", null ); // NOI18N
            properties[PROPERTY_maximizable] = new PropertyDescriptor ( "maximizable", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isMaximizable", "setMaximizable" ); // NOI18N
            properties[PROPERTY_maximum] = new PropertyDescriptor ( "maximum", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isMaximum", "setMaximum" ); // NOI18N
            properties[PROPERTY_maximumSize] = new PropertyDescriptor ( "maximumSize", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getMaximumSize", "setMaximumSize" ); // NOI18N
            properties[PROPERTY_maximumSizeSet] = new PropertyDescriptor ( "maximumSizeSet", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isMaximumSizeSet", null ); // NOI18N
            properties[PROPERTY_menuBar] = new PropertyDescriptor ( "menuBar", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getMenuBar", "setMenuBar" ); // NOI18N
            properties[PROPERTY_minimumSize] = new PropertyDescriptor ( "minimumSize", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getMinimumSize", "setMinimumSize" ); // NOI18N
            properties[PROPERTY_minimumSizeSet] = new PropertyDescriptor ( "minimumSizeSet", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isMinimumSizeSet", null ); // NOI18N
            properties[PROPERTY_mostRecentFocusOwner] = new PropertyDescriptor ( "mostRecentFocusOwner", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getMostRecentFocusOwner", null ); // NOI18N
            properties[PROPERTY_mouseListeners] = new PropertyDescriptor ( "mouseListeners", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getMouseListeners", null ); // NOI18N
            properties[PROPERTY_mouseMotionListeners] = new PropertyDescriptor ( "mouseMotionListeners", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getMouseMotionListeners", null ); // NOI18N
            properties[PROPERTY_mousePosition] = new PropertyDescriptor ( "mousePosition", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getMousePosition", null ); // NOI18N
            properties[PROPERTY_mouseWheelListeners] = new PropertyDescriptor ( "mouseWheelListeners", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getMouseWheelListeners", null ); // NOI18N
            properties[PROPERTY_name] = new PropertyDescriptor ( "name", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getName", "setName" ); // NOI18N
            properties[PROPERTY_nextFocusableComponent] = new PropertyDescriptor ( "nextFocusableComponent", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getNextFocusableComponent", "setNextFocusableComponent" ); // NOI18N
            properties[PROPERTY_normalBounds] = new PropertyDescriptor ( "normalBounds", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getNormalBounds", "setNormalBounds" ); // NOI18N
            properties[PROPERTY_opaque] = new PropertyDescriptor ( "opaque", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isOpaque", "setOpaque" ); // NOI18N
            properties[PROPERTY_optimizedDrawingEnabled] = new PropertyDescriptor ( "optimizedDrawingEnabled", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isOptimizedDrawingEnabled", null ); // NOI18N
            properties[PROPERTY_paintingForPrint] = new PropertyDescriptor ( "paintingForPrint", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isPaintingForPrint", null ); // NOI18N
            properties[PROPERTY_paintingTile] = new PropertyDescriptor ( "paintingTile", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isPaintingTile", null ); // NOI18N
            properties[PROPERTY_parent] = new PropertyDescriptor ( "parent", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getParent", null ); // NOI18N
            properties[PROPERTY_peer] = new PropertyDescriptor ( "peer", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getPeer", null ); // NOI18N
            properties[PROPERTY_preferredSize] = new PropertyDescriptor ( "preferredSize", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getPreferredSize", "setPreferredSize" ); // NOI18N
            properties[PROPERTY_preferredSizeSet] = new PropertyDescriptor ( "preferredSizeSet", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isPreferredSizeSet", null ); // NOI18N
            properties[PROPERTY_propertyChangeListeners] = new PropertyDescriptor ( "propertyChangeListeners", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getPropertyChangeListeners", null ); // NOI18N
            properties[PROPERTY_registeredKeyStrokes] = new PropertyDescriptor ( "registeredKeyStrokes", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getRegisteredKeyStrokes", null ); // NOI18N
            properties[PROPERTY_requestFocusEnabled] = new PropertyDescriptor ( "requestFocusEnabled", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isRequestFocusEnabled", "setRequestFocusEnabled" ); // NOI18N
            properties[PROPERTY_resizable] = new PropertyDescriptor ( "resizable", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isResizable", "setResizable" ); // NOI18N
            properties[PROPERTY_rootPane] = new PropertyDescriptor ( "rootPane", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getRootPane", null ); // NOI18N
            properties[PROPERTY_selected] = new PropertyDescriptor ( "selected", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isSelected", "setSelected" ); // NOI18N
            properties[PROPERTY_showing] = new PropertyDescriptor ( "showing", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isShowing", null ); // NOI18N
            properties[PROPERTY_size] = new PropertyDescriptor ( "size", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getSize", "setSize" ); // NOI18N
            properties[PROPERTY_title] = new PropertyDescriptor ( "title", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getTitle", "setTitle" ); // NOI18N
            properties[PROPERTY_toolkit] = new PropertyDescriptor ( "toolkit", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getToolkit", null ); // NOI18N
            properties[PROPERTY_toolTipText] = new PropertyDescriptor ( "toolTipText", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getToolTipText", "setToolTipText" ); // NOI18N
            properties[PROPERTY_topLevelAncestor] = new PropertyDescriptor ( "topLevelAncestor", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getTopLevelAncestor", null ); // NOI18N
            properties[PROPERTY_transferHandler] = new PropertyDescriptor ( "transferHandler", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getTransferHandler", "setTransferHandler" ); // NOI18N
            properties[PROPERTY_treeLock] = new PropertyDescriptor ( "treeLock", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getTreeLock", null ); // NOI18N
            properties[PROPERTY_UI] = new PropertyDescriptor ( "UI", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getUI", "setUI" ); // NOI18N
            properties[PROPERTY_UIClassID] = new PropertyDescriptor ( "UIClassID", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getUIClassID", null ); // NOI18N
            properties[PROPERTY_valid] = new PropertyDescriptor ( "valid", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isValid", null ); // NOI18N
            properties[PROPERTY_validateRoot] = new PropertyDescriptor ( "validateRoot", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isValidateRoot", null ); // NOI18N
            properties[PROPERTY_verifyInputWhenFocusTarget] = new PropertyDescriptor ( "verifyInputWhenFocusTarget", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getVerifyInputWhenFocusTarget", "setVerifyInputWhenFocusTarget" ); // NOI18N
            properties[PROPERTY_vetoableChangeListeners] = new PropertyDescriptor ( "vetoableChangeListeners", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getVetoableChangeListeners", null ); // NOI18N
            properties[PROPERTY_visible] = new PropertyDescriptor ( "visible", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "isVisible", "setVisible" ); // NOI18N
            properties[PROPERTY_visibleRect] = new PropertyDescriptor ( "visibleRect", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getVisibleRect", null ); // NOI18N
            properties[PROPERTY_warningString] = new PropertyDescriptor ( "warningString", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getWarningString", null ); // NOI18N
            properties[PROPERTY_width] = new PropertyDescriptor ( "width", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getWidth", null ); // NOI18N
            properties[PROPERTY_x] = new PropertyDescriptor ( "x", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getX", null ); // NOI18N
            properties[PROPERTY_y] = new PropertyDescriptor ( "y", net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "getY", null ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Properties

        // Here you can add code for customizing the properties array.

        return properties;     }//GEN-LAST:Properties
    // EventSet identifiers//GEN-FIRST:Events
    private static final int EVENT_ancestorListener = 0;
    private static final int EVENT_componentListener = 1;
    private static final int EVENT_containerListener = 2;
    private static final int EVENT_focusListener = 3;
    private static final int EVENT_hierarchyBoundsListener = 4;
    private static final int EVENT_hierarchyListener = 5;
    private static final int EVENT_inputMethodListener = 6;
    private static final int EVENT_internalFrameListener = 7;
    private static final int EVENT_keyListener = 8;
    private static final int EVENT_mouseListener = 9;
    private static final int EVENT_mouseMotionListener = 10;
    private static final int EVENT_mouseWheelListener = 11;
    private static final int EVENT_propertyChangeListener = 12;
    private static final int EVENT_vetoableChangeListener = 13;

    // EventSet array
    /*lazy EventSetDescriptor*/
    private static EventSetDescriptor[] getEdescriptor(){
        EventSetDescriptor[] eventSets = new EventSetDescriptor[14];
    
        try {
            eventSets[EVENT_ancestorListener] = new EventSetDescriptor ( net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "ancestorListener", javax.swing.event.AncestorListener.class, new String[] {"ancestorAdded", "ancestorRemoved", "ancestorMoved"}, "addAncestorListener", "removeAncestorListener" ); // NOI18N
            eventSets[EVENT_componentListener] = new EventSetDescriptor ( net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "componentListener", java.awt.event.ComponentListener.class, new String[] {"componentResized", "componentMoved", "componentShown", "componentHidden"}, "addComponentListener", "removeComponentListener" ); // NOI18N
            eventSets[EVENT_containerListener] = new EventSetDescriptor ( net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "containerListener", java.awt.event.ContainerListener.class, new String[] {"componentAdded", "componentRemoved"}, "addContainerListener", "removeContainerListener" ); // NOI18N
            eventSets[EVENT_focusListener] = new EventSetDescriptor ( net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "focusListener", java.awt.event.FocusListener.class, new String[] {"focusGained", "focusLost"}, "addFocusListener", "removeFocusListener" ); // NOI18N
            eventSets[EVENT_hierarchyBoundsListener] = new EventSetDescriptor ( net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "hierarchyBoundsListener", java.awt.event.HierarchyBoundsListener.class, new String[] {"ancestorMoved", "ancestorResized"}, "addHierarchyBoundsListener", "removeHierarchyBoundsListener" ); // NOI18N
            eventSets[EVENT_hierarchyListener] = new EventSetDescriptor ( net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "hierarchyListener", java.awt.event.HierarchyListener.class, new String[] {"hierarchyChanged"}, "addHierarchyListener", "removeHierarchyListener" ); // NOI18N
            eventSets[EVENT_inputMethodListener] = new EventSetDescriptor ( net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "inputMethodListener", java.awt.event.InputMethodListener.class, new String[] {"inputMethodTextChanged", "caretPositionChanged"}, "addInputMethodListener", "removeInputMethodListener" ); // NOI18N
            eventSets[EVENT_internalFrameListener] = new EventSetDescriptor ( net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "internalFrameListener", javax.swing.event.InternalFrameListener.class, new String[] {"internalFrameOpened", "internalFrameClosing", "internalFrameClosed", "internalFrameIconified", "internalFrameDeiconified", "internalFrameActivated", "internalFrameDeactivated"}, "addInternalFrameListener", "removeInternalFrameListener" ); // NOI18N
            eventSets[EVENT_keyListener] = new EventSetDescriptor ( net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "keyListener", java.awt.event.KeyListener.class, new String[] {"keyTyped", "keyPressed", "keyReleased"}, "addKeyListener", "removeKeyListener" ); // NOI18N
            eventSets[EVENT_mouseListener] = new EventSetDescriptor ( net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "mouseListener", java.awt.event.MouseListener.class, new String[] {"mouseClicked", "mousePressed", "mouseReleased", "mouseEntered", "mouseExited"}, "addMouseListener", "removeMouseListener" ); // NOI18N
            eventSets[EVENT_mouseMotionListener] = new EventSetDescriptor ( net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "mouseMotionListener", java.awt.event.MouseMotionListener.class, new String[] {"mouseDragged", "mouseMoved"}, "addMouseMotionListener", "removeMouseMotionListener" ); // NOI18N
            eventSets[EVENT_mouseWheelListener] = new EventSetDescriptor ( net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "mouseWheelListener", java.awt.event.MouseWheelListener.class, new String[] {"mouseWheelMoved"}, "addMouseWheelListener", "removeMouseWheelListener" ); // NOI18N
            eventSets[EVENT_propertyChangeListener] = new EventSetDescriptor ( net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "propertyChangeListener", java.beans.PropertyChangeListener.class, new String[] {"propertyChange"}, "addPropertyChangeListener", "removePropertyChangeListener" ); // NOI18N
            eventSets[EVENT_vetoableChangeListener] = new EventSetDescriptor ( net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class, "vetoableChangeListener", java.beans.VetoableChangeListener.class, new String[] {"vetoableChange"}, "addVetoableChangeListener", "removeVetoableChangeListener" ); // NOI18N
        }
        catch(IntrospectionException e) {
            e.printStackTrace();
        }//GEN-HEADEREND:Events

        // Here you can add code for customizing the event sets array.

        return eventSets;     }//GEN-LAST:Events
    // Method identifiers//GEN-FIRST:Methods
    private static final int METHOD_action0 = 0;
    private static final int METHOD_add1 = 1;
    private static final int METHOD_add2 = 2;
    private static final int METHOD_add3 = 3;
    private static final int METHOD_add4 = 4;
    private static final int METHOD_add5 = 5;
    private static final int METHOD_add6 = 6;
    private static final int METHOD_addNotify7 = 7;
    private static final int METHOD_addPropertyChangeListener8 = 8;
    private static final int METHOD_applyComponentOrientation9 = 9;
    private static final int METHOD_areFocusTraversalKeysSet10 = 10;
    private static final int METHOD_bounds11 = 11;
    private static final int METHOD_checkImage12 = 12;
    private static final int METHOD_checkImage13 = 13;
    private static final int METHOD_computeVisibleRect14 = 14;
    private static final int METHOD_contains15 = 15;
    private static final int METHOD_contains16 = 16;
    private static final int METHOD_countComponents17 = 17;
    private static final int METHOD_createImage18 = 18;
    private static final int METHOD_createImage19 = 19;
    private static final int METHOD_createToolTip20 = 20;
    private static final int METHOD_createVolatileImage21 = 21;
    private static final int METHOD_createVolatileImage22 = 22;
    private static final int METHOD_deliverEvent23 = 23;
    private static final int METHOD_disable24 = 24;
    private static final int METHOD_dispatchEvent25 = 25;
    private static final int METHOD_dispose26 = 26;
    private static final int METHOD_doDefaultCloseAction27 = 27;
    private static final int METHOD_doLayout28 = 28;
    private static final int METHOD_enable29 = 29;
    private static final int METHOD_enable30 = 30;
    private static final int METHOD_enableInputMethods31 = 31;
    private static final int METHOD_findComponentAt32 = 32;
    private static final int METHOD_findComponentAt33 = 33;
    private static final int METHOD_firePropertyChange34 = 34;
    private static final int METHOD_firePropertyChange35 = 35;
    private static final int METHOD_firePropertyChange36 = 36;
    private static final int METHOD_firePropertyChange37 = 37;
    private static final int METHOD_firePropertyChange38 = 38;
    private static final int METHOD_firePropertyChange39 = 39;
    private static final int METHOD_firePropertyChange40 = 40;
    private static final int METHOD_firePropertyChange41 = 41;
    private static final int METHOD_getActionForKeyStroke42 = 42;
    private static final int METHOD_getBaseline43 = 43;
    private static final int METHOD_getBounds44 = 44;
    private static final int METHOD_getClientProperty45 = 45;
    private static final int METHOD_getComponentAt46 = 46;
    private static final int METHOD_getComponentAt47 = 47;
    private static final int METHOD_getComponentZOrder48 = 48;
    private static final int METHOD_getConditionForKeyStroke49 = 49;
    private static final int METHOD_getDefaultLocale50 = 50;
    private static final int METHOD_getFocusTraversalKeys51 = 51;
    private static final int METHOD_getFontMetrics52 = 52;
    private static final int METHOD_getInsets53 = 53;
    private static final int METHOD_getListeners54 = 54;
    private static final int METHOD_getLocation55 = 55;
    private static final int METHOD_getMousePosition56 = 56;
    private static final int METHOD_getPopupLocation57 = 57;
    private static final int METHOD_getPropertyChangeListeners58 = 58;
    private static final int METHOD_getSize59 = 59;
    private static final int METHOD_getToolTipLocation60 = 60;
    private static final int METHOD_getToolTipText61 = 61;
    private static final int METHOD_gotFocus62 = 62;
    private static final int METHOD_grabFocus63 = 63;
    private static final int METHOD_handleEvent64 = 64;
    private static final int METHOD_hasFocus65 = 65;
    private static final int METHOD_hide66 = 66;
    private static final int METHOD_imageUpdate67 = 67;
    private static final int METHOD_insets68 = 68;
    private static final int METHOD_inside69 = 69;
    private static final int METHOD_invalidate70 = 70;
    private static final int METHOD_isAncestorOf71 = 71;
    private static final int METHOD_isFocusCycleRoot72 = 72;
    private static final int METHOD_isFocusOwner73 = 73;
    private static final int METHOD_isLightweightComponent74 = 74;
    private static final int METHOD_keyDown75 = 75;
    private static final int METHOD_keyUp76 = 76;
    private static final int METHOD_layout77 = 77;
    private static final int METHOD_list78 = 78;
    private static final int METHOD_list79 = 79;
    private static final int METHOD_list80 = 80;
    private static final int METHOD_list81 = 81;
    private static final int METHOD_list82 = 82;
    private static final int METHOD_locate83 = 83;
    private static final int METHOD_location84 = 84;
    private static final int METHOD_lostFocus85 = 85;
    private static final int METHOD_minimumSize86 = 86;
    private static final int METHOD_mouseDown87 = 87;
    private static final int METHOD_mouseDrag88 = 88;
    private static final int METHOD_mouseEnter89 = 89;
    private static final int METHOD_mouseExit90 = 90;
    private static final int METHOD_mouseMove91 = 91;
    private static final int METHOD_mouseUp92 = 92;
    private static final int METHOD_move93 = 93;
    private static final int METHOD_moveToBack94 = 94;
    private static final int METHOD_moveToFront95 = 95;
    private static final int METHOD_nextFocus96 = 96;
    private static final int METHOD_pack97 = 97;
    private static final int METHOD_paint98 = 98;
    private static final int METHOD_paintAll99 = 99;
    private static final int METHOD_paintComponents100 = 100;
    private static final int METHOD_paintImmediately101 = 101;
    private static final int METHOD_paintImmediately102 = 102;
    private static final int METHOD_postEvent103 = 103;
    private static final int METHOD_preferredSize104 = 104;
    private static final int METHOD_prepareImage105 = 105;
    private static final int METHOD_prepareImage106 = 106;
    private static final int METHOD_print107 = 107;
    private static final int METHOD_printAll108 = 108;
    private static final int METHOD_printComponents109 = 109;
    private static final int METHOD_putClientProperty110 = 110;
    private static final int METHOD_refresh111 = 111;
    private static final int METHOD_registerKeyboardAction112 = 112;
    private static final int METHOD_registerKeyboardAction113 = 113;
    private static final int METHOD_remove114 = 114;
    private static final int METHOD_remove115 = 115;
    private static final int METHOD_remove116 = 116;
    private static final int METHOD_removeAll117 = 117;
    private static final int METHOD_removeNotify118 = 118;
    private static final int METHOD_removePropertyChangeListener119 = 119;
    private static final int METHOD_repaint120 = 120;
    private static final int METHOD_repaint121 = 121;
    private static final int METHOD_repaint122 = 122;
    private static final int METHOD_repaint123 = 123;
    private static final int METHOD_repaint124 = 124;
    private static final int METHOD_requestDefaultFocus125 = 125;
    private static final int METHOD_requestFocus126 = 126;
    private static final int METHOD_requestFocus127 = 127;
    private static final int METHOD_requestFocusInWindow128 = 128;
    private static final int METHOD_resetKeyboardActions129 = 129;
    private static final int METHOD_reshape130 = 130;
    private static final int METHOD_resize131 = 131;
    private static final int METHOD_resize132 = 132;
    private static final int METHOD_restoreSubcomponentFocus133 = 133;
    private static final int METHOD_revalidate134 = 134;
    private static final int METHOD_scrollRectToVisible135 = 135;
    private static final int METHOD_setBounds136 = 136;
    private static final int METHOD_setComponentZOrder137 = 137;
    private static final int METHOD_setDefaultLocale138 = 138;
    private static final int METHOD_setLayer139 = 139;
    private static final int METHOD_show140 = 140;
    private static final int METHOD_show141 = 141;
    private static final int METHOD_size142 = 142;
    private static final int METHOD_toBack143 = 143;
    private static final int METHOD_toFront144 = 144;
    private static final int METHOD_toString145 = 145;
    private static final int METHOD_transferFocus146 = 146;
    private static final int METHOD_transferFocusBackward147 = 147;
    private static final int METHOD_transferFocusDownCycle148 = 148;
    private static final int METHOD_transferFocusUpCycle149 = 149;
    private static final int METHOD_unregisterKeyboardAction150 = 150;
    private static final int METHOD_update151 = 151;
    private static final int METHOD_updateUI152 = 152;
    private static final int METHOD_validate153 = 153;

    // Method array 
    /*lazy MethodDescriptor*/
    private static MethodDescriptor[] getMdescriptor(){
        MethodDescriptor[] methods = new MethodDescriptor[154];
    
        try {
            methods[METHOD_action0] = new MethodDescriptor(java.awt.Component.class.getMethod("action", new Class[] {java.awt.Event.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_action0].setDisplayName ( "" );
            methods[METHOD_add1] = new MethodDescriptor(java.awt.Component.class.getMethod("add", new Class[] {java.awt.PopupMenu.class})); // NOI18N
            methods[METHOD_add1].setDisplayName ( "" );
            methods[METHOD_add2] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_add2].setDisplayName ( "" );
            methods[METHOD_add3] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.lang.String.class, java.awt.Component.class})); // NOI18N
            methods[METHOD_add3].setDisplayName ( "" );
            methods[METHOD_add4] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class, int.class})); // NOI18N
            methods[METHOD_add4].setDisplayName ( "" );
            methods[METHOD_add5] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_add5].setDisplayName ( "" );
            methods[METHOD_add6] = new MethodDescriptor(java.awt.Container.class.getMethod("add", new Class[] {java.awt.Component.class, java.lang.Object.class, int.class})); // NOI18N
            methods[METHOD_add6].setDisplayName ( "" );
            methods[METHOD_addNotify7] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("addNotify", new Class[] {})); // NOI18N
            methods[METHOD_addNotify7].setDisplayName ( "" );
            methods[METHOD_addPropertyChangeListener8] = new MethodDescriptor(java.awt.Container.class.getMethod("addPropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class})); // NOI18N
            methods[METHOD_addPropertyChangeListener8].setDisplayName ( "" );
            methods[METHOD_applyComponentOrientation9] = new MethodDescriptor(java.awt.Container.class.getMethod("applyComponentOrientation", new Class[] {java.awt.ComponentOrientation.class})); // NOI18N
            methods[METHOD_applyComponentOrientation9].setDisplayName ( "" );
            methods[METHOD_areFocusTraversalKeysSet10] = new MethodDescriptor(java.awt.Container.class.getMethod("areFocusTraversalKeysSet", new Class[] {int.class})); // NOI18N
            methods[METHOD_areFocusTraversalKeysSet10].setDisplayName ( "" );
            methods[METHOD_bounds11] = new MethodDescriptor(java.awt.Component.class.getMethod("bounds", new Class[] {})); // NOI18N
            methods[METHOD_bounds11].setDisplayName ( "" );
            methods[METHOD_checkImage12] = new MethodDescriptor(java.awt.Component.class.getMethod("checkImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_checkImage12].setDisplayName ( "" );
            methods[METHOD_checkImage13] = new MethodDescriptor(java.awt.Component.class.getMethod("checkImage", new Class[] {java.awt.Image.class, int.class, int.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_checkImage13].setDisplayName ( "" );
            methods[METHOD_computeVisibleRect14] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("computeVisibleRect", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_computeVisibleRect14].setDisplayName ( "" );
            methods[METHOD_contains15] = new MethodDescriptor(java.awt.Component.class.getMethod("contains", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_contains15].setDisplayName ( "" );
            methods[METHOD_contains16] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("contains", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_contains16].setDisplayName ( "" );
            methods[METHOD_countComponents17] = new MethodDescriptor(java.awt.Container.class.getMethod("countComponents", new Class[] {})); // NOI18N
            methods[METHOD_countComponents17].setDisplayName ( "" );
            methods[METHOD_createImage18] = new MethodDescriptor(java.awt.Component.class.getMethod("createImage", new Class[] {java.awt.image.ImageProducer.class})); // NOI18N
            methods[METHOD_createImage18].setDisplayName ( "" );
            methods[METHOD_createImage19] = new MethodDescriptor(java.awt.Component.class.getMethod("createImage", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_createImage19].setDisplayName ( "" );
            methods[METHOD_createToolTip20] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("createToolTip", new Class[] {})); // NOI18N
            methods[METHOD_createToolTip20].setDisplayName ( "" );
            methods[METHOD_createVolatileImage21] = new MethodDescriptor(java.awt.Component.class.getMethod("createVolatileImage", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_createVolatileImage21].setDisplayName ( "" );
            methods[METHOD_createVolatileImage22] = new MethodDescriptor(java.awt.Component.class.getMethod("createVolatileImage", new Class[] {int.class, int.class, java.awt.ImageCapabilities.class})); // NOI18N
            methods[METHOD_createVolatileImage22].setDisplayName ( "" );
            methods[METHOD_deliverEvent23] = new MethodDescriptor(java.awt.Container.class.getMethod("deliverEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_deliverEvent23].setDisplayName ( "" );
            methods[METHOD_disable24] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("disable", new Class[] {})); // NOI18N
            methods[METHOD_disable24].setDisplayName ( "" );
            methods[METHOD_dispatchEvent25] = new MethodDescriptor(java.awt.Component.class.getMethod("dispatchEvent", new Class[] {java.awt.AWTEvent.class})); // NOI18N
            methods[METHOD_dispatchEvent25].setDisplayName ( "" );
            methods[METHOD_dispose26] = new MethodDescriptor(javax.swing.JInternalFrame.class.getMethod("dispose", new Class[] {})); // NOI18N
            methods[METHOD_dispose26].setDisplayName ( "" );
            methods[METHOD_doDefaultCloseAction27] = new MethodDescriptor(javax.swing.JInternalFrame.class.getMethod("doDefaultCloseAction", new Class[] {})); // NOI18N
            methods[METHOD_doDefaultCloseAction27].setDisplayName ( "" );
            methods[METHOD_doLayout28] = new MethodDescriptor(java.awt.Container.class.getMethod("doLayout", new Class[] {})); // NOI18N
            methods[METHOD_doLayout28].setDisplayName ( "" );
            methods[METHOD_enable29] = new MethodDescriptor(java.awt.Component.class.getMethod("enable", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_enable29].setDisplayName ( "" );
            methods[METHOD_enable30] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("enable", new Class[] {})); // NOI18N
            methods[METHOD_enable30].setDisplayName ( "" );
            methods[METHOD_enableInputMethods31] = new MethodDescriptor(java.awt.Component.class.getMethod("enableInputMethods", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_enableInputMethods31].setDisplayName ( "" );
            methods[METHOD_findComponentAt32] = new MethodDescriptor(java.awt.Container.class.getMethod("findComponentAt", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_findComponentAt32].setDisplayName ( "" );
            methods[METHOD_findComponentAt33] = new MethodDescriptor(java.awt.Container.class.getMethod("findComponentAt", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_findComponentAt33].setDisplayName ( "" );
            methods[METHOD_firePropertyChange34] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, byte.class, byte.class})); // NOI18N
            methods[METHOD_firePropertyChange34].setDisplayName ( "" );
            methods[METHOD_firePropertyChange35] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, short.class, short.class})); // NOI18N
            methods[METHOD_firePropertyChange35].setDisplayName ( "" );
            methods[METHOD_firePropertyChange36] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, long.class, long.class})); // NOI18N
            methods[METHOD_firePropertyChange36].setDisplayName ( "" );
            methods[METHOD_firePropertyChange37] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, float.class, float.class})); // NOI18N
            methods[METHOD_firePropertyChange37].setDisplayName ( "" );
            methods[METHOD_firePropertyChange38] = new MethodDescriptor(java.awt.Component.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, double.class, double.class})); // NOI18N
            methods[METHOD_firePropertyChange38].setDisplayName ( "" );
            methods[METHOD_firePropertyChange39] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, boolean.class, boolean.class})); // NOI18N
            methods[METHOD_firePropertyChange39].setDisplayName ( "" );
            methods[METHOD_firePropertyChange40] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, int.class, int.class})); // NOI18N
            methods[METHOD_firePropertyChange40].setDisplayName ( "" );
            methods[METHOD_firePropertyChange41] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("firePropertyChange", new Class[] {java.lang.String.class, char.class, char.class})); // NOI18N
            methods[METHOD_firePropertyChange41].setDisplayName ( "" );
            methods[METHOD_getActionForKeyStroke42] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getActionForKeyStroke", new Class[] {javax.swing.KeyStroke.class})); // NOI18N
            methods[METHOD_getActionForKeyStroke42].setDisplayName ( "" );
            methods[METHOD_getBaseline43] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getBaseline", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_getBaseline43].setDisplayName ( "" );
            methods[METHOD_getBounds44] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getBounds", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_getBounds44].setDisplayName ( "" );
            methods[METHOD_getClientProperty45] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getClientProperty", new Class[] {java.lang.Object.class})); // NOI18N
            methods[METHOD_getClientProperty45].setDisplayName ( "" );
            methods[METHOD_getComponentAt46] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentAt", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_getComponentAt46].setDisplayName ( "" );
            methods[METHOD_getComponentAt47] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentAt", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_getComponentAt47].setDisplayName ( "" );
            methods[METHOD_getComponentZOrder48] = new MethodDescriptor(java.awt.Container.class.getMethod("getComponentZOrder", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_getComponentZOrder48].setDisplayName ( "" );
            methods[METHOD_getConditionForKeyStroke49] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getConditionForKeyStroke", new Class[] {javax.swing.KeyStroke.class})); // NOI18N
            methods[METHOD_getConditionForKeyStroke49].setDisplayName ( "" );
            methods[METHOD_getDefaultLocale50] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getDefaultLocale", new Class[] {})); // NOI18N
            methods[METHOD_getDefaultLocale50].setDisplayName ( "" );
            methods[METHOD_getFocusTraversalKeys51] = new MethodDescriptor(java.awt.Container.class.getMethod("getFocusTraversalKeys", new Class[] {int.class})); // NOI18N
            methods[METHOD_getFocusTraversalKeys51].setDisplayName ( "" );
            methods[METHOD_getFontMetrics52] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getFontMetrics", new Class[] {java.awt.Font.class})); // NOI18N
            methods[METHOD_getFontMetrics52].setDisplayName ( "" );
            methods[METHOD_getInsets53] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getInsets", new Class[] {java.awt.Insets.class})); // NOI18N
            methods[METHOD_getInsets53].setDisplayName ( "" );
            methods[METHOD_getListeners54] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getListeners", new Class[] {java.lang.Class.class})); // NOI18N
            methods[METHOD_getListeners54].setDisplayName ( "" );
            methods[METHOD_getLocation55] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getLocation", new Class[] {java.awt.Point.class})); // NOI18N
            methods[METHOD_getLocation55].setDisplayName ( "" );
            methods[METHOD_getMousePosition56] = new MethodDescriptor(java.awt.Container.class.getMethod("getMousePosition", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_getMousePosition56].setDisplayName ( "" );
            methods[METHOD_getPopupLocation57] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getPopupLocation", new Class[] {java.awt.event.MouseEvent.class})); // NOI18N
            methods[METHOD_getPopupLocation57].setDisplayName ( "" );
            methods[METHOD_getPropertyChangeListeners58] = new MethodDescriptor(java.awt.Component.class.getMethod("getPropertyChangeListeners", new Class[] {java.lang.String.class})); // NOI18N
            methods[METHOD_getPropertyChangeListeners58].setDisplayName ( "" );
            methods[METHOD_getSize59] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getSize", new Class[] {java.awt.Dimension.class})); // NOI18N
            methods[METHOD_getSize59].setDisplayName ( "" );
            methods[METHOD_getToolTipLocation60] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getToolTipLocation", new Class[] {java.awt.event.MouseEvent.class})); // NOI18N
            methods[METHOD_getToolTipLocation60].setDisplayName ( "" );
            methods[METHOD_getToolTipText61] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("getToolTipText", new Class[] {java.awt.event.MouseEvent.class})); // NOI18N
            methods[METHOD_getToolTipText61].setDisplayName ( "" );
            methods[METHOD_gotFocus62] = new MethodDescriptor(java.awt.Component.class.getMethod("gotFocus", new Class[] {java.awt.Event.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_gotFocus62].setDisplayName ( "" );
            methods[METHOD_grabFocus63] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("grabFocus", new Class[] {})); // NOI18N
            methods[METHOD_grabFocus63].setDisplayName ( "" );
            methods[METHOD_handleEvent64] = new MethodDescriptor(java.awt.Component.class.getMethod("handleEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_handleEvent64].setDisplayName ( "" );
            methods[METHOD_hasFocus65] = new MethodDescriptor(java.awt.Component.class.getMethod("hasFocus", new Class[] {})); // NOI18N
            methods[METHOD_hasFocus65].setDisplayName ( "" );
            methods[METHOD_hide66] = new MethodDescriptor(javax.swing.JInternalFrame.class.getMethod("hide", new Class[] {})); // NOI18N
            methods[METHOD_hide66].setDisplayName ( "" );
            methods[METHOD_imageUpdate67] = new MethodDescriptor(java.awt.Component.class.getMethod("imageUpdate", new Class[] {java.awt.Image.class, int.class, int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_imageUpdate67].setDisplayName ( "" );
            methods[METHOD_insets68] = new MethodDescriptor(java.awt.Container.class.getMethod("insets", new Class[] {})); // NOI18N
            methods[METHOD_insets68].setDisplayName ( "" );
            methods[METHOD_inside69] = new MethodDescriptor(java.awt.Component.class.getMethod("inside", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_inside69].setDisplayName ( "" );
            methods[METHOD_invalidate70] = new MethodDescriptor(java.awt.Container.class.getMethod("invalidate", new Class[] {})); // NOI18N
            methods[METHOD_invalidate70].setDisplayName ( "" );
            methods[METHOD_isAncestorOf71] = new MethodDescriptor(java.awt.Container.class.getMethod("isAncestorOf", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_isAncestorOf71].setDisplayName ( "" );
            methods[METHOD_isFocusCycleRoot72] = new MethodDescriptor(java.awt.Container.class.getMethod("isFocusCycleRoot", new Class[] {java.awt.Container.class})); // NOI18N
            methods[METHOD_isFocusCycleRoot72].setDisplayName ( "" );
            methods[METHOD_isFocusOwner73] = new MethodDescriptor(java.awt.Component.class.getMethod("isFocusOwner", new Class[] {})); // NOI18N
            methods[METHOD_isFocusOwner73].setDisplayName ( "" );
            methods[METHOD_isLightweightComponent74] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("isLightweightComponent", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_isLightweightComponent74].setDisplayName ( "" );
            methods[METHOD_keyDown75] = new MethodDescriptor(java.awt.Component.class.getMethod("keyDown", new Class[] {java.awt.Event.class, int.class})); // NOI18N
            methods[METHOD_keyDown75].setDisplayName ( "" );
            methods[METHOD_keyUp76] = new MethodDescriptor(java.awt.Component.class.getMethod("keyUp", new Class[] {java.awt.Event.class, int.class})); // NOI18N
            methods[METHOD_keyUp76].setDisplayName ( "" );
            methods[METHOD_layout77] = new MethodDescriptor(java.awt.Container.class.getMethod("layout", new Class[] {})); // NOI18N
            methods[METHOD_layout77].setDisplayName ( "" );
            methods[METHOD_list78] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {})); // NOI18N
            methods[METHOD_list78].setDisplayName ( "" );
            methods[METHOD_list79] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {java.io.PrintStream.class})); // NOI18N
            methods[METHOD_list79].setDisplayName ( "" );
            methods[METHOD_list80] = new MethodDescriptor(java.awt.Component.class.getMethod("list", new Class[] {java.io.PrintWriter.class})); // NOI18N
            methods[METHOD_list80].setDisplayName ( "" );
            methods[METHOD_list81] = new MethodDescriptor(java.awt.Container.class.getMethod("list", new Class[] {java.io.PrintStream.class, int.class})); // NOI18N
            methods[METHOD_list81].setDisplayName ( "" );
            methods[METHOD_list82] = new MethodDescriptor(java.awt.Container.class.getMethod("list", new Class[] {java.io.PrintWriter.class, int.class})); // NOI18N
            methods[METHOD_list82].setDisplayName ( "" );
            methods[METHOD_locate83] = new MethodDescriptor(java.awt.Container.class.getMethod("locate", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_locate83].setDisplayName ( "" );
            methods[METHOD_location84] = new MethodDescriptor(java.awt.Component.class.getMethod("location", new Class[] {})); // NOI18N
            methods[METHOD_location84].setDisplayName ( "" );
            methods[METHOD_lostFocus85] = new MethodDescriptor(java.awt.Component.class.getMethod("lostFocus", new Class[] {java.awt.Event.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_lostFocus85].setDisplayName ( "" );
            methods[METHOD_minimumSize86] = new MethodDescriptor(java.awt.Container.class.getMethod("minimumSize", new Class[] {})); // NOI18N
            methods[METHOD_minimumSize86].setDisplayName ( "" );
            methods[METHOD_mouseDown87] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseDown", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseDown87].setDisplayName ( "" );
            methods[METHOD_mouseDrag88] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseDrag", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseDrag88].setDisplayName ( "" );
            methods[METHOD_mouseEnter89] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseEnter", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseEnter89].setDisplayName ( "" );
            methods[METHOD_mouseExit90] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseExit", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseExit90].setDisplayName ( "" );
            methods[METHOD_mouseMove91] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseMove", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseMove91].setDisplayName ( "" );
            methods[METHOD_mouseUp92] = new MethodDescriptor(java.awt.Component.class.getMethod("mouseUp", new Class[] {java.awt.Event.class, int.class, int.class})); // NOI18N
            methods[METHOD_mouseUp92].setDisplayName ( "" );
            methods[METHOD_move93] = new MethodDescriptor(java.awt.Component.class.getMethod("move", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_move93].setDisplayName ( "" );
            methods[METHOD_moveToBack94] = new MethodDescriptor(javax.swing.JInternalFrame.class.getMethod("moveToBack", new Class[] {})); // NOI18N
            methods[METHOD_moveToBack94].setDisplayName ( "" );
            methods[METHOD_moveToFront95] = new MethodDescriptor(javax.swing.JInternalFrame.class.getMethod("moveToFront", new Class[] {})); // NOI18N
            methods[METHOD_moveToFront95].setDisplayName ( "" );
            methods[METHOD_nextFocus96] = new MethodDescriptor(java.awt.Component.class.getMethod("nextFocus", new Class[] {})); // NOI18N
            methods[METHOD_nextFocus96].setDisplayName ( "" );
            methods[METHOD_pack97] = new MethodDescriptor(javax.swing.JInternalFrame.class.getMethod("pack", new Class[] {})); // NOI18N
            methods[METHOD_pack97].setDisplayName ( "" );
            methods[METHOD_paint98] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("paint", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paint98].setDisplayName ( "" );
            methods[METHOD_paintAll99] = new MethodDescriptor(java.awt.Component.class.getMethod("paintAll", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paintAll99].setDisplayName ( "" );
            methods[METHOD_paintComponents100] = new MethodDescriptor(java.awt.Container.class.getMethod("paintComponents", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_paintComponents100].setDisplayName ( "" );
            methods[METHOD_paintImmediately101] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("paintImmediately", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_paintImmediately101].setDisplayName ( "" );
            methods[METHOD_paintImmediately102] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("paintImmediately", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_paintImmediately102].setDisplayName ( "" );
            methods[METHOD_postEvent103] = new MethodDescriptor(java.awt.Component.class.getMethod("postEvent", new Class[] {java.awt.Event.class})); // NOI18N
            methods[METHOD_postEvent103].setDisplayName ( "" );
            methods[METHOD_preferredSize104] = new MethodDescriptor(java.awt.Container.class.getMethod("preferredSize", new Class[] {})); // NOI18N
            methods[METHOD_preferredSize104].setDisplayName ( "" );
            methods[METHOD_prepareImage105] = new MethodDescriptor(java.awt.Component.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_prepareImage105].setDisplayName ( "" );
            methods[METHOD_prepareImage106] = new MethodDescriptor(java.awt.Component.class.getMethod("prepareImage", new Class[] {java.awt.Image.class, int.class, int.class, java.awt.image.ImageObserver.class})); // NOI18N
            methods[METHOD_prepareImage106].setDisplayName ( "" );
            methods[METHOD_print107] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("print", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_print107].setDisplayName ( "" );
            methods[METHOD_printAll108] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("printAll", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_printAll108].setDisplayName ( "" );
            methods[METHOD_printComponents109] = new MethodDescriptor(java.awt.Container.class.getMethod("printComponents", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_printComponents109].setDisplayName ( "" );
            methods[METHOD_putClientProperty110] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("putClientProperty", new Class[] {java.lang.Object.class, java.lang.Object.class})); // NOI18N
            methods[METHOD_putClientProperty110].setDisplayName ( "" );
            methods[METHOD_refresh111] = new MethodDescriptor(net.geeklythings.fieldmarshal.ui.TournamentInternalFrame.class.getMethod("refresh", new Class[] {})); // NOI18N
            methods[METHOD_refresh111].setDisplayName ( "" );
            methods[METHOD_registerKeyboardAction112] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("registerKeyboardAction", new Class[] {java.awt.event.ActionListener.class, java.lang.String.class, javax.swing.KeyStroke.class, int.class})); // NOI18N
            methods[METHOD_registerKeyboardAction112].setDisplayName ( "" );
            methods[METHOD_registerKeyboardAction113] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("registerKeyboardAction", new Class[] {java.awt.event.ActionListener.class, javax.swing.KeyStroke.class, int.class})); // NOI18N
            methods[METHOD_registerKeyboardAction113].setDisplayName ( "" );
            methods[METHOD_remove114] = new MethodDescriptor(java.awt.Component.class.getMethod("remove", new Class[] {java.awt.MenuComponent.class})); // NOI18N
            methods[METHOD_remove114].setDisplayName ( "" );
            methods[METHOD_remove115] = new MethodDescriptor(java.awt.Container.class.getMethod("remove", new Class[] {int.class})); // NOI18N
            methods[METHOD_remove115].setDisplayName ( "" );
            methods[METHOD_remove116] = new MethodDescriptor(javax.swing.JInternalFrame.class.getMethod("remove", new Class[] {java.awt.Component.class})); // NOI18N
            methods[METHOD_remove116].setDisplayName ( "" );
            methods[METHOD_removeAll117] = new MethodDescriptor(java.awt.Container.class.getMethod("removeAll", new Class[] {})); // NOI18N
            methods[METHOD_removeAll117].setDisplayName ( "" );
            methods[METHOD_removeNotify118] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("removeNotify", new Class[] {})); // NOI18N
            methods[METHOD_removeNotify118].setDisplayName ( "" );
            methods[METHOD_removePropertyChangeListener119] = new MethodDescriptor(java.awt.Component.class.getMethod("removePropertyChangeListener", new Class[] {java.lang.String.class, java.beans.PropertyChangeListener.class})); // NOI18N
            methods[METHOD_removePropertyChangeListener119].setDisplayName ( "" );
            methods[METHOD_repaint120] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {})); // NOI18N
            methods[METHOD_repaint120].setDisplayName ( "" );
            methods[METHOD_repaint121] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {long.class})); // NOI18N
            methods[METHOD_repaint121].setDisplayName ( "" );
            methods[METHOD_repaint122] = new MethodDescriptor(java.awt.Component.class.getMethod("repaint", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_repaint122].setDisplayName ( "" );
            methods[METHOD_repaint123] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("repaint", new Class[] {long.class, int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_repaint123].setDisplayName ( "" );
            methods[METHOD_repaint124] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("repaint", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_repaint124].setDisplayName ( "" );
            methods[METHOD_requestDefaultFocus125] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("requestDefaultFocus", new Class[] {})); // NOI18N
            methods[METHOD_requestDefaultFocus125].setDisplayName ( "" );
            methods[METHOD_requestFocus126] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("requestFocus", new Class[] {})); // NOI18N
            methods[METHOD_requestFocus126].setDisplayName ( "" );
            methods[METHOD_requestFocus127] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("requestFocus", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_requestFocus127].setDisplayName ( "" );
            methods[METHOD_requestFocusInWindow128] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("requestFocusInWindow", new Class[] {})); // NOI18N
            methods[METHOD_requestFocusInWindow128].setDisplayName ( "" );
            methods[METHOD_resetKeyboardActions129] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("resetKeyboardActions", new Class[] {})); // NOI18N
            methods[METHOD_resetKeyboardActions129].setDisplayName ( "" );
            methods[METHOD_reshape130] = new MethodDescriptor(javax.swing.JInternalFrame.class.getMethod("reshape", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_reshape130].setDisplayName ( "" );
            methods[METHOD_resize131] = new MethodDescriptor(java.awt.Component.class.getMethod("resize", new Class[] {int.class, int.class})); // NOI18N
            methods[METHOD_resize131].setDisplayName ( "" );
            methods[METHOD_resize132] = new MethodDescriptor(java.awt.Component.class.getMethod("resize", new Class[] {java.awt.Dimension.class})); // NOI18N
            methods[METHOD_resize132].setDisplayName ( "" );
            methods[METHOD_restoreSubcomponentFocus133] = new MethodDescriptor(javax.swing.JInternalFrame.class.getMethod("restoreSubcomponentFocus", new Class[] {})); // NOI18N
            methods[METHOD_restoreSubcomponentFocus133].setDisplayName ( "" );
            methods[METHOD_revalidate134] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("revalidate", new Class[] {})); // NOI18N
            methods[METHOD_revalidate134].setDisplayName ( "" );
            methods[METHOD_scrollRectToVisible135] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("scrollRectToVisible", new Class[] {java.awt.Rectangle.class})); // NOI18N
            methods[METHOD_scrollRectToVisible135].setDisplayName ( "" );
            methods[METHOD_setBounds136] = new MethodDescriptor(java.awt.Component.class.getMethod("setBounds", new Class[] {int.class, int.class, int.class, int.class})); // NOI18N
            methods[METHOD_setBounds136].setDisplayName ( "" );
            methods[METHOD_setComponentZOrder137] = new MethodDescriptor(java.awt.Container.class.getMethod("setComponentZOrder", new Class[] {java.awt.Component.class, int.class})); // NOI18N
            methods[METHOD_setComponentZOrder137].setDisplayName ( "" );
            methods[METHOD_setDefaultLocale138] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("setDefaultLocale", new Class[] {java.util.Locale.class})); // NOI18N
            methods[METHOD_setDefaultLocale138].setDisplayName ( "" );
            methods[METHOD_setLayer139] = new MethodDescriptor(javax.swing.JInternalFrame.class.getMethod("setLayer", new Class[] {java.lang.Integer.class})); // NOI18N
            methods[METHOD_setLayer139].setDisplayName ( "" );
            methods[METHOD_show140] = new MethodDescriptor(java.awt.Component.class.getMethod("show", new Class[] {boolean.class})); // NOI18N
            methods[METHOD_show140].setDisplayName ( "" );
            methods[METHOD_show141] = new MethodDescriptor(javax.swing.JInternalFrame.class.getMethod("show", new Class[] {})); // NOI18N
            methods[METHOD_show141].setDisplayName ( "" );
            methods[METHOD_size142] = new MethodDescriptor(java.awt.Component.class.getMethod("size", new Class[] {})); // NOI18N
            methods[METHOD_size142].setDisplayName ( "" );
            methods[METHOD_toBack143] = new MethodDescriptor(javax.swing.JInternalFrame.class.getMethod("toBack", new Class[] {})); // NOI18N
            methods[METHOD_toBack143].setDisplayName ( "" );
            methods[METHOD_toFront144] = new MethodDescriptor(javax.swing.JInternalFrame.class.getMethod("toFront", new Class[] {})); // NOI18N
            methods[METHOD_toFront144].setDisplayName ( "" );
            methods[METHOD_toString145] = new MethodDescriptor(java.awt.Component.class.getMethod("toString", new Class[] {})); // NOI18N
            methods[METHOD_toString145].setDisplayName ( "" );
            methods[METHOD_transferFocus146] = new MethodDescriptor(java.awt.Component.class.getMethod("transferFocus", new Class[] {})); // NOI18N
            methods[METHOD_transferFocus146].setDisplayName ( "" );
            methods[METHOD_transferFocusBackward147] = new MethodDescriptor(java.awt.Component.class.getMethod("transferFocusBackward", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusBackward147].setDisplayName ( "" );
            methods[METHOD_transferFocusDownCycle148] = new MethodDescriptor(java.awt.Container.class.getMethod("transferFocusDownCycle", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusDownCycle148].setDisplayName ( "" );
            methods[METHOD_transferFocusUpCycle149] = new MethodDescriptor(java.awt.Component.class.getMethod("transferFocusUpCycle", new Class[] {})); // NOI18N
            methods[METHOD_transferFocusUpCycle149].setDisplayName ( "" );
            methods[METHOD_unregisterKeyboardAction150] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("unregisterKeyboardAction", new Class[] {javax.swing.KeyStroke.class})); // NOI18N
            methods[METHOD_unregisterKeyboardAction150].setDisplayName ( "" );
            methods[METHOD_update151] = new MethodDescriptor(javax.swing.JComponent.class.getMethod("update", new Class[] {java.awt.Graphics.class})); // NOI18N
            methods[METHOD_update151].setDisplayName ( "" );
            methods[METHOD_updateUI152] = new MethodDescriptor(javax.swing.JInternalFrame.class.getMethod("updateUI", new Class[] {})); // NOI18N
            methods[METHOD_updateUI152].setDisplayName ( "" );
            methods[METHOD_validate153] = new MethodDescriptor(java.awt.Container.class.getMethod("validate", new Class[] {})); // NOI18N
            methods[METHOD_validate153].setDisplayName ( "" );
        }
        catch( Exception e) {}//GEN-HEADEREND:Methods

        // Here you can add code for customizing the methods array.
        
        return methods;     }//GEN-LAST:Methods
    private static java.awt.Image iconColor16 = null;//GEN-BEGIN:IconsDef
    private static java.awt.Image iconColor32 = null;
    private static java.awt.Image iconMono16 = null;
    private static java.awt.Image iconMono32 = null;//GEN-END:IconsDef
    private static String iconNameC16 = null;//GEN-BEGIN:Icons
    private static String iconNameC32 = null;
    private static String iconNameM16 = null;
    private static String iconNameM32 = null;//GEN-END:Icons
    private static final int defaultPropertyIndex = -1;//GEN-BEGIN:Idx
    private static final int defaultEventIndex = -1;//GEN-END:Idx

//GEN-FIRST:Superclass
    // Here you can add code for customizing the Superclass BeanInfo.
//GEN-LAST:Superclass
    /**
     * Gets the bean's
     * <code>BeanDescriptor</code>s.
     *
     * @return BeanDescriptor describing the editable properties of this bean.
     * May return null if the information should be obtained by automatic
     * analysis.
     */
    @Override
    public BeanDescriptor getBeanDescriptor() {
        return getBdescriptor();
    }

    /**
     * Gets the bean's
     * <code>PropertyDescriptor</code>s.
     *
     * @return An array of PropertyDescriptors describing the editable
     * properties supported by this bean. May return null if the information
     * should be obtained by automatic analysis.
     * <p>
     * If a property is indexed, then its entry in the result array will belong
     * to the IndexedPropertyDescriptor subclass of PropertyDescriptor. A client
     * of getPropertyDescriptors can use "instanceof" to check if a given
     * PropertyDescriptor is an IndexedPropertyDescriptor.
     */
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        return getPdescriptor();
    }

    /**
     * Gets the bean's
     * <code>EventSetDescriptor</code>s.
     *
     * @return An array of EventSetDescriptors describing the kinds of events
     * fired by this bean. May return null if the information should be obtained
     * by automatic analysis.
     */
    @Override
    public EventSetDescriptor[] getEventSetDescriptors() {
        return getEdescriptor();
    }

    /**
     * Gets the bean's
     * <code>MethodDescriptor</code>s.
     *
     * @return An array of MethodDescriptors describing the methods implemented
     * by this bean. May return null if the information should be obtained by
     * automatic analysis.
     */
    @Override
    public MethodDescriptor[] getMethodDescriptors() {
        return getMdescriptor();
    }

    /**
     * A bean may have a "default" property that is the property that will
     * mostly commonly be initially chosen for update by human's who are
     * customizing the bean.
     *
     * @return Index of default property in the PropertyDescriptor array
     * returned by getPropertyDescriptors.
     * <P>	Returns -1 if there is no default property.
     */
    @Override
    public int getDefaultPropertyIndex() {
        return defaultPropertyIndex;
    }

    /**
     * A bean may have a "default" event that is the event that will mostly
     * commonly be used by human's when using the bean.
     *
     * @return Index of default event in the EventSetDescriptor array returned
     * by getEventSetDescriptors.
     * <P>	Returns -1 if there is no default event.
     */
    @Override
    public int getDefaultEventIndex() {
        return defaultEventIndex;
    }

    /**
     * This method returns an image object that can be used to represent the
     * bean in toolboxes, toolbars, etc. Icon images will typically be GIFs, but
     * may in future include other formats.
     * <p>
     * Beans aren't required to provide icons and may return null from this
     * method.
     * <p>
     * There are four possible flavors of icons (16x16 color, 32x32 color, 16x16
     * mono, 32x32 mono). If a bean choses to only support a single icon we
     * recommend supporting 16x16 color.
     * <p>
     * We recommend that icons have a "transparent" background so they can be
     * rendered onto an existing background.
     *
     * @param iconKind The kind of icon requested. This should be one of the
     * constant values ICON_COLOR_16x16, ICON_COLOR_32x32, ICON_MONO_16x16, or
     * ICON_MONO_32x32.
     * @return An image object representing the requested icon. May return null
     * if no suitable icon is available.
     */
    @Override
    public java.awt.Image getIcon(int iconKind) {
        switch (iconKind) {
            case ICON_COLOR_16x16:
                if (iconNameC16 == null) {
                    return null;
                } else {
                    if (iconColor16 == null) {
                        iconColor16 = loadImage(iconNameC16);
                    }
                    return iconColor16;
                }
            case ICON_COLOR_32x32:
                if (iconNameC32 == null) {
                    return null;
                } else {
                    if (iconColor32 == null) {
                        iconColor32 = loadImage(iconNameC32);
                    }
                    return iconColor32;
                }
            case ICON_MONO_16x16:
                if (iconNameM16 == null) {
                    return null;
                } else {
                    if (iconMono16 == null) {
                        iconMono16 = loadImage(iconNameM16);
                    }
                    return iconMono16;
                }
            case ICON_MONO_32x32:
                if (iconNameM32 == null) {
                    return null;
                } else {
                    if (iconMono32 == null) {
                        iconMono32 = loadImage(iconNameM32);
                    }
                    return iconMono32;
                }
            default:
                return null;
        }
    }
}
