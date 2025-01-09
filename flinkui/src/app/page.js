"use client";

import { useState } from "react";

export default function Dashboard() {
  const [selected, setSelected] = useState("Dashboard");

  const menuItems = [
    { name: "Dashboard", icon: "📊" },
    { name: "Connections", icon: "🔗" },
    { name: "Streams", icon: "🌊" },
    { name: "Pipelines", icon: "🔧" },
    { name: "Secrets", icon: "🔒" },
    { name: "Access Control", icon: "⚙️" },
  ];

  return (
    <div className="flex flex-col md:flex-row h-screen bg-gray-100">
      {/* Sidebar */}
      <div className="w-full md:w-64 bg-white shadow-md">
        <div className="p-6 text-xl font-bold border-b">Decodable</div>
        <nav className="mt-6 space-y-4">
          {menuItems.map((item) => (
            <button
              key={item.name}
              onClick={() => setSelected(item.name)}
              className={`flex items-center px-6 py-3 text-sm font-medium transition ${
                selected === item.name
                  ? "bg-blue-100 text-blue-600"
                  : "text-gray-700 hover:bg-gray-200"
              }`}
            >
              <span className="mr-4 text-lg">{item.icon}</span>
              {item.name}
            </button>
          ))}
        </nav>
      </div>

      {/* Main Content */}
      <div className="flex-1">
        <Header />
        <MainContent />
      </div>
    </div>
  );
}

function Header() {
  return (
    <header className="flex flex-wrap items-center justify-between p-4 bg-white shadow">
      <h1 className="text-lg md:text-2xl font-bold">Welcome to Decodable</h1>
      <button className="px-4 py-2 mt-4 text-white bg-blue-500 rounded-md hover:bg-blue-600 md:mt-0">
        Logout
      </button>
    </header>
  );
}

function MainContent() {
  return (
    <div className="flex flex-col items-center justify-center p-4 md:p-10 space-y-8">
      {/* Title */}
      <h2 className="text-base md:text-lg font-semibold text-gray-600 text-center">
        Real-time ETL Powered by Apache Flink and Debezium
      </h2>

      {/* Diagram */}
      <div className="flex flex-col md:flex-row items-center justify-center w-full space-y-6 md:space-y-0 md:space-x-6">
        {/* Sources */}
        <div className="flex flex-row md:flex-col items-center space-x-2 md:space-x-0 md:space-y-2">
          <SourceItem name="CDC" />
          <SourceItem name="JSON" />
          <SourceItem name="Kafka" />
          <SourceItem name="Pub/Sub" />
        </div>

        {/* Connection Lines */}
        <div className="hidden md:flex flex-1">
          <div className="h-full w-1 bg-blue-500"></div>
        </div>

        {/* Core Decodable */}
        <div className="flex items-center justify-center p-6 text-white bg-blue-600 rounded-lg">
          <h3 className="text-lg md:text-2xl font-bold">Decodable</h3>
        </div>

        {/* Connection Lines */}
        <div className="hidden md:flex flex-1">
          <div className="h-full w-1 bg-blue-500"></div>
        </div>

        {/* Sinks */}
        <div className="flex flex-row md:flex-col items-center space-x-4 md:space-x-0 md:space-y-4">
          <SinkItem name="Snowflake" />
          <SinkItem name="S3 Bucket" />
          <SinkItem name="Elasticsearch" />
          <SinkItem name="Datadog" />
        </div>
      </div>
    </div>
  );
}

function SourceItem({ name }) {
  return (
    <div className="flex items-center justify-center w-20 h-20 md:w-24 md:h-24 p-4 text-xs md:text-sm font-medium text-center bg-gray-200 rounded-lg">
      {name}
    </div>
  );
}

function SinkItem({ name }) {
  return (
    <div className="flex items-center justify-center w-20 h-20 md:w-24 md:h-24 p-4 text-xs md:text-sm font-medium text-center bg-gray-200 rounded-lg">
      {name}
    </div>
  );
}
