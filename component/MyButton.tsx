import React from 'react';
import { View, Text, Touchable, TouchableOpacity, NativeModules } from 'react-native';

const { DeviceAdminModule } = NativeModules;

const MyButton = () => {
  return (
    <View>
        <TouchableOpacity
        onPress={() => DeviceAdminModule.requestAdmin()}
        >
            <Text>Click Me</Text>
        </TouchableOpacity>    
    </View>
  );
};

export default MyButton;
